package uz.gita.newsapp.data.remote.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import uz.gita.newsapp.data.remote.response.NewsResponse

interface TopHeadlinesApi {

    @GET("top-headlines/category/health/{lang}.json")
    fun getHealthNews(@Path("lang")lang: String): Call<NewsResponse>

    @GET("top-headlines/category/business/{lang}.json")
    fun getBusinessNews(@Path("lang")lang: String): Call<NewsResponse>

    @GET("top-headlines/category/entertainment/{lang}.json")
    fun getEntertainmentNews(@Path("lang")lang: String): Call<NewsResponse>

    @GET("top-headlines/category/general/{lang}.json")
    fun getGeneralNews(@Path("lang")lang: String): Call<NewsResponse>

    @GET("top-headlines/category/science/{lang}.json")
    fun getScienceNews(@Path("lang")lang: String): Call<NewsResponse>

    @GET("top-headlines/category/sports/{lang}.json")
    fun getSportNews(@Path("lang")lang: String): Call<NewsResponse>

    @GET("top-headlines/category/technology/{lang}.json")
    fun getTechnologyNews(@Path("lang")lang: String): Call<NewsResponse>
}