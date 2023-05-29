package uz.gita.newsapp.presentation.viewmodel

import androidx.lifecycle.LiveData

interface InterestingNewsScreenViewModel {
    val backLiveData: LiveData<Unit>
    val openNewsScreen: LiveData<String>

    fun back()
    fun openNewsScreen(data: String)
}