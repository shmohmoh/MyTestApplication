package com.example.mytestapplication.data.datasource

import com.example.mytestapplication.data.entity.NewsResponse
import retrofit2.Response

interface NewsDataSource {

    suspend fun getNewsHeadline(country : String) : Response<NewsResponse>
}