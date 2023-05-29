package uz.gita.newsapp.presentation.viewmodel

import androidx.lifecycle.LiveData
import uz.gita.newsapp.data.remote.response.ArticlesItem
import uz.gita.newsapp.data.remote.response.NewsResponse

interface UniversalScreenForNewsViewModel {
    val loadLiveData: LiveData<List<ArticlesItem>>
    val backLiveData: LiveData<Unit>
    val progressLiveData: LiveData<Boolean>
    val errorLiveData: LiveData<String>

    fun load(data: String)
    fun back()
}