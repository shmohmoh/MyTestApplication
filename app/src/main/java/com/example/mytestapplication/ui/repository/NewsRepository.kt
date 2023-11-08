package com.example.mytestapplication.ui.repository

import com.example.mytestapplication.data.datasource.NewsDataSource
import com.example.mytestapplication.data.entity.NewsResponse
import com.example.utilities.ResourceState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class NewsRepository @Inject constructor(
    private val newsDataSource: NewsDataSource
){
//    suspend fun getNewsHeadline(country :String) : Response<NewsResponse>{
//        return newsDataSource.getNewsHeadline(country)
//    }

    suspend fun getNewsHeadline(country :String) : Flow<ResourceState<NewsResponse>>{
        return flow {
            emit(ResourceState.Loading())
            val response = newsDataSource.getNewsHeadline(country)
            if(response.isSuccessful && response.body() != null){
                emit(ResourceState.Success(response.body()!!))
            }else{
                emit(ResourceState.Error("Error fetching news data"))
            }
        }.catch {
            it ->
            emit(ResourceState.Error(it?.localizedMessage ?: "Error fetching news data"))
        }
    }

}