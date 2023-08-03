package com.example.actividad7m6.modelos.remoto

import com.google.gson.annotations.SerializedName

data class MarsClass(
    @SerializedName("price") val price:Int,
    @SerializedName("id") val id:String,
    @SerializedName("type") val type:String,
    @SerializedName("img_src") val imgSrc:String
    )
