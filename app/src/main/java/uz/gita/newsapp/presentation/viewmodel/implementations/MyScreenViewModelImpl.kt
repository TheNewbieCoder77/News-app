package uz.gita.newsapp.presentation.viewmodel.implementations

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import uz.gita.newsapp.data.remote.ApiClient
import uz.gita.newsapp.data.remote.api.EveryThingApi
import uz.gita.newsapp.data.remote.response.ArticlesItem
import uz.gita.newsapp.data.remote.response.NewsResponse
import uz.gita.newsapp.presentation.viewmodel.MyScreenViewModel

class MyScreenViewModelImpl : ViewModel(), MyScreenViewModel {
    private val everyThingApi = ApiClient.retrofit.create(EveryThingApi::class.java)
    override val backLiveData = MutableLiveData<Unit>()
    override val loadLiveData = MutableLiveData<List<ArticlesItem>>()
    override val progressLiveData = MutableLiveData<Boolean>()
    override val errorLiveData = MutableLiveData<String>()


    override fun load(data: String) {
        progressLiveData.value = true
        when(data){
            "bbc-news" ->{
                everyThingApi.getBBCNews().enqueue(object : Callback<NewsResponse>{
                    override fun onResponse(call: Call<NewsResponse>, response: Response<NewsResponse>) {
                        progressLiveData.value = false
                        if(response.isSuccessful){
                            response.body()?.let {
                                loadLiveData.value = it.articles
                            }
                        }else{
                            progressLiveData.value = false
                            errorLiveData.value = "Xatolik"
                        }
                    }

                    override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                        progressLiveData.value = false
                        errorLiveData.value = "Check your Internet connection"
                    }

                })
            }
            "cnn" ->{
                everyThingApi.getCNNNews().enqueue(object : Callback<NewsResponse>{
                    override fun onResponse(call: Call<NewsResponse>, response: Response<NewsResponse>) {
                        progressLiveData.value = false
                        if(response.isSuccessful){
                            response.body()?.let {
                                loadLiveData.value = it.articles
                            }
                        }else{
                            progressLiveData.value = false
                            errorLiveData.value = "Xatolik"
                        }
                    }

                    override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                        progressLiveData.value = false
                        errorLiveData.value = "Check your Internet connection"
                    }

                })
            }
            "fox-news" ->{
                everyThingApi.getFoxNews().enqueue(object : Callback<NewsResponse>{
                    override fun onResponse(call: Call<NewsResponse>, response: Response<NewsResponse>) {
                        progressLiveData.value = false
                        if(response.isSuccessful){
                            response.body()?.let {
                                loadLiveData.value = it.articles
                            }
                        }else{
                            progressLiveData.value = false
                            errorLiveData.value = "Xatolik"
                        }
                    }

                    override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                        progressLiveData.value = false
                        errorLiveData.value = "Check your Internet connection"
                    }

                })
            }
            "google-news" ->{
                everyThingApi.getGoogleNews().enqueue(object : Callback<NewsResponse>{
                    override fun onResponse(call: Call<NewsResponse>, response: Response<NewsResponse>) {
                        progressLiveData.value = false
                        if(response.isSuccessful){
                            response.body()?.let {
                                loadLiveData.value = it.articles
                            }
                        }else{
                            progressLiveData.value = false
                            errorLiveData.value = "Xatolik"
                        }
                    }

                    override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                        progressLiveData.value = false
                        errorLiveData.value = "Check your Internet connection"
                    }
                })
            }
        }
    }

    override fun back() {
        backLiveData.value = Unit
    }
}

