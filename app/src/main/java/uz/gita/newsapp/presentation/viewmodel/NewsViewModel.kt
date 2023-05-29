package uz.gita.newsapp.presentation.viewmodel

import androidx.lifecycle.LiveData

interface NewsViewModel {
    val openChooseLanguageDialog: LiveData<Unit>
    val openInterestingNewsScreen: LiveData<Unit>

    fun openChooseDialog()
    fun openInterestingNewsScreen()
}