package uz.gita.newsapp.presentation.viewmodel.implementations


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import uz.gita.newsapp.presentation.viewmodel.SplashViewModel
import java.util.concurrent.Executors

class SplashViewModelImpl : ViewModel(), SplashViewModel {
    override val openNewsScreenLiveData = MutableLiveData<Unit>()
    private val executor = Executors.newSingleThreadExecutor()

    init{
        executor.execute{
            Thread.sleep(2000)
            openNewsScreenLiveData.postValue(Unit)
        }
    }

}