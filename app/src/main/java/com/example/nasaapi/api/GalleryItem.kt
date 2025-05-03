package com.example.nasaapi.api

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GalleryItem (
    val title: String,
    val count: Int = 75,

    @Json(name = "url") val url:String
)