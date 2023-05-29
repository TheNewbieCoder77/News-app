package uz.gita.newsapp.presentation.ui.screens

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.gita.newsapp.R
import uz.gita.newsapp.databinding.ScreenInterestingNewsBinding
import uz.gita.newsapp.presentation.viewmodel.InterestingNewsScreenViewModel
import uz.gita.newsapp.presentation.viewmodel.implementations.InterestingNewsScreenViewModelImpl

class InterestingNewsScreen : Fragment(R.layout.screen_interesting_news) {
    private val binding by viewBinding(ScreenInterestingNewsBinding::bind)
    private val viewModel: InterestingNewsScreenViewModel by viewModels<InterestingNewsScreenViewModelImpl>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.openNewsScreen.observe(this,openNewsScreenObserver)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.backLiveData.observe(viewLifecycleOwner,backObserver)
        clickEvents()
    }

    private fun clickEvents()= with(binding){
        bbcId.setOnClickListener{
            viewModel.openNewsScreen("bbc-news")
        }
        cnnId.setOnClickListener{
            viewModel.openNewsScreen("cnn")
        }
        foxId.setOnClickListener{
            viewModel.openNewsScreen("fox-news")
        }
        googleId.setOnClickListener{
            viewModel.openNewsScreen("google-news")
        }
        binding.btnBack.setOnClickListener{
            viewModel.back()
        }
    }

    private val backObserver = Observer<Unit>{
        findNavController().popBackStack()
    }

    private val openNewsScreenObserver = Observer<String>{
        val bundle = Bundle()
        bundle.putString("TYPE",it)
        findNavController().navigate(R.id.action_interestingNewsScreen_to_myScreen,bundle)
    }
}