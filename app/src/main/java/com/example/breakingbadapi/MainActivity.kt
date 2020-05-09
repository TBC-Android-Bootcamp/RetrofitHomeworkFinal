package com.example.breakingbadapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.breakingbadapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(ApiService::class.java)

        api.getCharacters().enqueue(object : Callback<List<Character>>{
            override fun onResponse(call: Call<List<Character>>, response: Response<List<Character>>) {
                d("bacho", "onResponse ${response.body()!![0].charId}")
                showData(response.body()!!)
            }
            override fun onFailure(call: Call<List<Character>>, t: Throwable) {
                d("bacho", "onFailure")
            }
        })
    }

    private fun showData(characters: List<Character>) {
        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = RecyclerAdapter(characters, this@MainActivity)
        }
    }
}
