package uz.gita.newsapp.presentation.viewmodel.implementations


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import uz.gita.newsapp.presentation.viewmodel.InterestingNewsScreenViewModel

class InterestingNewsScreenViewModelImpl : ViewModel(), InterestingNewsScreenViewModel {
    override val backLiveData = MutableLiveData<Unit>()
    override val openNewsScreen = MutableLiveData<String>()

    override fun back() {
        backLiveData.value = Unit
    }

    override fun openNewsScreen(data: String) {
        openNewsScreen.value = data
    }

}