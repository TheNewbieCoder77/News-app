package uz.gita.newsapp.presentation.ui.screens

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import uz.gita.newsapp.R
import uz.gita.newsapp.presentation.viewmodel.SplashViewModel
import uz.gita.newsapp.presentation.viewmodel.implementations.SplashViewModelImpl

@SuppressLint("CustomSplashScreen")
class SplashScreen : Fragment(R.layout.screen_splash) {
    private val viewModel: SplashViewModel by viewModels<SplashViewModelImpl>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.openNewsScreenLiveData.observe(viewLifecycleOwner,openNewsScreenObserver)
    }

    private val openNewsScreenObserver = Observer<Unit>{
        findNavController().navigate(R.id.action_splashScreen_to_newsScreen)
    }
}