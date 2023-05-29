package uz.gita.newsapp.presentation.viewmodel.implementations


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import uz.gita.newsapp.data.local.AppPreferences
import uz.gita.newsapp.data.remote.ApiClient
import uz.gita.newsapp.data.remote.api.TopHeadlinesApi
import uz.gita.newsapp.data.remote.response.ArticlesItem
import uz.gita.newsapp.data.remote.response.NewsResponse
import uz.gita.newsapp.presentation.viewmodel.UniversalScreenForNewsViewModel

class UniversalScreenForNewsViewModelImpl : ViewModel(), UniversalScreenForNewsViewModel {
    private val topHeadlinesApi = ApiClient.retrofit.create(TopHeadlinesApi::class.java)
    private val pref = AppPreferences.getInstance()
    override val loadLiveData = MutableLiveData<List<ArticlesItem>>()
    override val backLiveData = MutableLiveData<Unit>()
    override val progressLiveData = MutableLiveData<Boolean>()
    override val errorLiveData = MutableLiveData<String>()

    override fun load(data: String) {
        progressLiveData.value = true
        when(data){
            "Business" ->{
                topHeadlinesApi.getBusinessNews(pref.language).enqueue(object : Callback<NewsResponse>{
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
            "Health" ->{
                topHeadlinesApi.getHealthNews(pref.language).enqueue(object : Callback<NewsResponse>{
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
            "Science" ->{
                topHeadlinesApi.getScienceNews(pref.language).enqueue(object : Callback<NewsResponse>{
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
            "Entertainment" ->{
                topHeadlinesApi.getEntertainmentNews(pref.language).enqueue(object : Callback<NewsResponse>{
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
            "General" ->{
                topHeadlinesApi.getGeneralNews(pref.language).enqueue(object : Callback<NewsResponse>{
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
            "Sports" ->{
                topHeadlinesApi.getSportNews(pref.language).enqueue(object : Callback<NewsResponse>{
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
            "Technology" ->{
                topHeadlinesApi.getTechnologyNews(pref.language).enqueue(object : Callback<NewsResponse>{
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

