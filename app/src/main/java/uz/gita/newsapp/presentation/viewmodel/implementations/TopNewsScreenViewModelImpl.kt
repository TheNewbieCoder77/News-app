package uz.gita.newsapp.presentation.viewmodel.implementations


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import uz.gita.newsapp.data.local.AppPreferences
import uz.gita.newsapp.presentation.viewmodel.TopNewsScreenViewModel

class TopNewsScreenViewModelImpl: ViewModel(), TopNewsScreenViewModel {
    override val openNewsLiveData = MutableLiveData<String>()
    override val backLiveData = MutableLiveData<Unit>()
    override val loadLiveData = MutableLiveData<List<String>>()
    private val listNames = listOf("Business","Health","Science","Entertainment","General","Sports","Technology")
    private val pref = AppPreferences.getInstance()



    override fun openNews(data: String) {
        openNewsLiveData.value = data
    }

    override fun back() {
        backLiveData.value = Unit
    }

    override fun load(lang: String) {
        pref.language = lang
        loadLiveData.value = listNames
    }

}