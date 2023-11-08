package com.example.mytestapplication.data.entity

import javax.xml.transform.Source

data class NewsResponse(
    val status :String,
    val totalResults : Int,
    val articles : List<Article>
)

data class Article(
    val author : String?,
    val title : String?,
    val desc : String?,
    val url :String?,
    val urlToImage : String?,
    val publishedAt :String?,
    val content :String?,
    val source : Source?
)

data class Source(
    val id : String?,
    val name : String?
)