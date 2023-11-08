package com.example.mytestapplication.ui.screens

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.mytestapplication.data.entity.NewsResponse
import com.example.mytestapplication.ui.components.Loader
import com.example.mytestapplication.ui.components.NewsRowComponent
import com.example.mytestapplication.ui.viewmodel.NewsViewModel
import com.example.utilities.ResourceState

const val TAG = "HomeScreen"

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    newsViewModel: NewsViewModel = hiltViewModel()
) {
    val newsResponse = newsViewModel.news.collectAsState()
    Surface(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)){
        when (newsResponse) {
            is ResourceState.Loading<*> -> {
                Log.d(TAG, "Inside_loading")
                Loader()
            }

            is ResourceState.Success<*> -> {
                val response = (newsResponse as ResourceState.Success<NewsResponse>).data
                Log.d(TAG, "Inside_success ${response.status} : ${response.totalResults}")
//                NewsList(response = response)
                if (response.articles.isNotEmpty()) {
                    NewsRowComponent(page = 0, response.articles[0])
                }
            }

            is ResourceState.Error<*> -> {
                val error = (newsResponse as ResourceState.Error<*>)
                Log.d(TAG, "Inside_error $error")
            }
        }

    }

}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}