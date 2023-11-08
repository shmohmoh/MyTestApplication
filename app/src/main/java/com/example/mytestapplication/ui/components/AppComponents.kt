package com.example.mytestapplication.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.mytestapplication.R
import com.example.mytestapplication.data.entity.Article
import com.example.mytestapplication.data.entity.NewsResponse
import com.example.mytestapplication.ui.theme.Purple40

@Composable
fun Loader(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        CircularProgressIndicator(
        modifier = Modifier
            .size(50.dp)
            .padding(10.dp),
        color = Purple40)
    }
}

@Composable
fun NewsList(response: NewsResponse){
    LazyColumn{
        items(response.articles) {article ->
            NormalTextComponent(textValue = article.title ?: "NA")
        }
    }
}

@Composable
fun NormalTextComponent(textValue : String){
    Text(modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight()
        .padding(8.dp)
        ,text = textValue,
        style = TextStyle(
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal
        )
    )
}

@Composable
fun NewsRowComponent(page: Int ,article: Article ){
//    NormalTextComponent(textValue = "$page \n\n  ${article.title}")
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
            .background(Color.White)
    ) {
        AsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .height(240.dp),
            model = article.urlToImage, contentDescription = "",
            contentScale = ContentScale.Fit,
            placeholder = painterResource(id = R.drawable.logo),
            error = painterResource(id = R.drawable.logo))

        Spacer(modifier = Modifier.size(20.dp))
        HeadingTextComponent(textValue = article.title ?: "")
        Spacer(modifier = Modifier.size(10.dp))
        NormalTextComponent(textValue = article.content ?: "")

    }
}

@Composable
fun HeadingTextComponent(textValue: String){
    Text(modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight()
        .padding(8.dp)
        ,text = textValue,
        style = TextStyle(
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
    )
}

@Composable
fun NewsRowComponentPreview(){
    val article = Article(
        author = "MMM",
        title =" Dummy new titles",
        null,
        null,
        null,
        null,
        null,
        null
    )
    NewsRowComponent(page = 0, article = article)
}