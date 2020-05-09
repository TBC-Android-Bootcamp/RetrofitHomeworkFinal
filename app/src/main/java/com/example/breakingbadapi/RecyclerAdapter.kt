package com.example.breakingbadapi

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_layout.view.*

class RecyclerAdapter(private val characters: List<Character>, private val context: Context) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    override fun getItemCount() = characters.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val character = characters[position]
        holder.name.text = character.name
        holder.id.text = character.charId.toString()
        holder.status.text = character.status
        holder.nickname.text = character.nickname
        Glide.with(context).load(character.img).into(holder.avatar);
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.tvName
        val id: TextView = itemView.tvCharId
        val nickname: TextView = itemView.tvNickname
        val status: TextView = itemView.tvStatus
        val avatar: ImageView = itemView.avatar
    }
}