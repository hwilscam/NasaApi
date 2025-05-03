package com.example.nasaapi

import com.example.nasaapi.api.GalleryItem
import com.example.nasaapi.api.NasaApi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create

class PhotoRepository {
    private val nasaApi: NasaApi
    private val apiKey = "H4FxG4aJIHrxBHcUuFEVdXE3rdxDKCycrSCc1e5h"
    private val image_amount = 75

    init {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://api.nasa.gov/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

        nasaApi = retrofit.create()
    }

    suspend fun fetchPhotos(apiKey: String, image_amount: Int): List<GalleryItem> =
        nasaApi.fetchPhotos(this.apiKey, image_amount = image_amount)

}