package com.example.actividad7m6.modelos.remoto

import retrofit2.Response
import retrofit2.http.GET

interface MarsApi {
    @GET("realestate")
    suspend fun fecthMarsList(): Response<List<MarsClass>>
}