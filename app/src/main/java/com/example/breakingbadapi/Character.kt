package com.example.breakingbadapi

import com.google.gson.annotations.SerializedName

class Character (
    val name: String,
    @SerializedName("char_id")
    val charId: Int,
    val nickname: String,
    val status: String,
    val img: String
)