package uz.gita.newsapp.presentation.viewmodel

import androidx.lifecycle.LiveData

interface TopNewsScreenViewModel {
    val openNewsLiveData: LiveData<String>
    val backLiveData: LiveData<Unit>
    val loadLiveData: LiveData<List<String>>

    fun openNews(data: String)
    fun back()
    fun load(lang: String)
}