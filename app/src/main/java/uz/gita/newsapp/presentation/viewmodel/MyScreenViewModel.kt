package uz.gita.newsapp.presentation.viewmodel

import androidx.lifecycle.LiveData
import uz.gita.newsapp.data.remote.response.ArticlesItem

interface MyScreenViewModel {
    val backLiveData: LiveData<Unit>
    val loadLiveData: LiveData<List<ArticlesItem>>
    val progressLiveData: LiveData<Boolean>
    val errorLiveData: LiveData<String>

    fun load(data: String)
    fun back()
}