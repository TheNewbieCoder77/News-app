package uz.gita.newsapp.presentation.viewmodel.implementations

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import uz.gita.newsapp.presentation.viewmodel.NewsViewModel

class NewsViewModelImpl : ViewModel(), NewsViewModel {
    override val openChooseLanguageDialog = MutableLiveData<Unit>()
    override val openInterestingNewsScreen = MutableLiveData<Unit>()

    override fun openChooseDialog() {
        openChooseLanguageDialog.value = Unit
    }

    override fun openInterestingNewsScreen() {
        openInterestingNewsScreen.value = Unit
    }
}