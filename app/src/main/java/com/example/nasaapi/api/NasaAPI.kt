package com.example.nasaapi.api

import retrofit2.http.GET
import retrofit2.http.Query

private const val API_KEY = "H4FxG4aJIHrxBHcUuFEVdXE3rdxDKCycrSCc1e5h"

interface NasaApi {

    @GET("planetary/apod")
    suspend fun fetchAPOD(
        @Query("api_key") apiKey: String = API_KEY,
        @Query("format") format: String = "json",
        @Query("nojsoncallback") noJsonCallback: Int = 1,
        @Query("extras") extras: String = "url_s",
    ): NasaResponse
}