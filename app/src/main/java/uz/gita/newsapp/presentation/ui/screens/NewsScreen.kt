package uz.gita.newsapp.presentation.ui.screens

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.gita.newsapp.R
import uz.gita.newsapp.databinding.ScreenNewsBinding
import uz.gita.newsapp.presentation.ui.dialog.ChooseLanguageDialog
import uz.gita.newsapp.presentation.viewmodel.NewsViewModel
import uz.gita.newsapp.presentation.viewmodel.implementations.NewsViewModelImpl

class NewsScreen : Fragment(R.layout.screen_news) {
    private val binding by viewBinding(ScreenNewsBinding::bind)
    private val viewModel: NewsViewModel by viewModels<NewsViewModelImpl>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.openInterestingNewsScreen.observe(this,openInterestingNewsObserver)
        viewModel.openChooseLanguageDialog.observe(this,openChooseLanguageObserver)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        clickEvents()
    }

    private fun clickEvents(){
        binding.btnTopNews.setOnClickListener{
            viewModel.openChooseDialog()
        }
        binding.btnInterestingNews.setOnClickListener{
            viewModel.openInterestingNewsScreen()
        }
    }


    private val openInterestingNewsObserver = Observer<Unit>{
        findNavController().navigate(R.id.action_newsScreen_to_interestingNewsScreen)
    }

    private val openChooseLanguageObserver = Observer<Unit>{
        val dialog = ChooseLanguageDialog()
        dialog.setChooseCountryListener {
            val bundle = Bundle()
            bundle.putString("LANGUAGE",it)
            findNavController().navigate(R.id.action_newsScreen_to_topNewsScreen,bundle)
        }
        dialog.show(childFragmentManager,null)
    }
}