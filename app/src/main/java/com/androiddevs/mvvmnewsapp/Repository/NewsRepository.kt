package com.androiddevs.mvvmnewsapp.Repository

import com.androiddevs.mvvmnewsapp.api.RetrofitInstance
import com.androiddevs.mvvmnewsapp.db.ArticleDatabase
import com.androiddevs.mvvmnewsapp.models.Article

class NewsRepository(val db: ArticleDatabase) {

    suspend fun getBreakingNews(countrycode:String, pageNumber:Int) =
        RetrofitInstance.api.getBreakingNews(countrycode,pageNumber)

    suspend fun searchNews(SearchQuery: String, pageNumber: Int) =
        RetrofitInstance.api.searchForNews(SearchQuery, pageNumber)

    suspend fun upsert(article: Article) = db.getArticleDao().upsert(article)

    fun getSavedNews() = db.getArticleDao().getAllArticles()

    suspend fun deleteArticle(article: Article) = db.getArticleDao().deleteArticle(article)
}