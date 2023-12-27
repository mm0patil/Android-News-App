package com.androiddevs.mvvmnewsapp.api


import com.androiddevs.mvvmnewsapp.models.NewsResponse
import com.androiddevs.mvvmnewsapp.utils.Constants.Companion.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsAPI {

    @GET("v2/top-headlines")
    suspend fun getBreakingNews(
        @Query( "country")
        countryCode: String = "us",

        @Query("page")
        pageNumber: Number = 1,

        @Query("apiKey")
        apiKey: String = API_KEY
    ) : Response<NewsResponse>

    @GET("v2/everything")
    suspend fun searchForNews(
        @Query( "q")
        SearchQuery: String,

        @Query("page")
        pageNumber: Number = 1,

        @Query("apiKey")
        apiKey: String = API_KEY
    ) : Response<NewsResponse>
}