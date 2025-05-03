package com.example.nasaapi.api

import retrofit2.http.GET
import retrofit2.http.Query

private const val API_KEY = "H4FxG4aJIHrxBHcUuFEVdXE3rdxDKCycrSCc1e5h"
interface NasaApi {
    @GET("planetary/apod")
    suspend fun fetchPhotos(
        @Query("api_key") apiKey: String = API_KEY,
        @Query("count") imageAmount: Int = 75,
    ): List<GalleryItem>

}
