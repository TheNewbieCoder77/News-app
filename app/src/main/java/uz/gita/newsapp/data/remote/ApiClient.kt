package uz.gita.newsapp.data.remote

import com.readystatesoftware.chuck.ChuckInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import uz.gita.newsapp.app.App

object ApiClient {
    private val myClient = OkHttpClient.Builder()
        .addInterceptor(ChuckInterceptor(uz.gita.newsapp.app.App.context))
        .build()

    val retrofit = Retrofit.Builder()
        .baseUrl("https://saurav.tech/NewsAPI/")
//        .client(myClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}