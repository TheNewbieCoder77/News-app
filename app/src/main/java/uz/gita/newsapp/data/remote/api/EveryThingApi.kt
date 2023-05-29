package uz.gita.newsapp.data.remote.api

import retrofit2.Call
import retrofit2.http.GET
import uz.gita.newsapp.data.remote.response.NewsResponse

interface EveryThingApi {
    @GET("everything/cnn.json")
    fun getCNNNews(): Call<NewsResponse>

    @GET("everything/bbc-news.json")
    fun getBBCNews(): Call<NewsResponse>

    @GET("everything/fox-news.json")
    fun getFoxNews(): Call<NewsResponse>

    @GET("everything/google-news.json")
    fun getGoogleNews(): Call<NewsResponse>
}