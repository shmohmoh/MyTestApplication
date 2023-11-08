package com.example.mytestapplication.data.api

import com.example.mytestapplication.data.entity.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("v2/top-headlines")
    suspend fun getNewsHeadline(
        @Query("country") country : String,
        @Query("apiKey") apiKey : String = "08e00242791f4c4a8f468a08c534fb21"
    ) : Response<NewsResponse>
}