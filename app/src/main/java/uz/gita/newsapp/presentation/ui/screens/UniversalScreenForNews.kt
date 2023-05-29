package uz.gita.newsapp.presentation.ui.screens

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.gita.newsapp.R
import uz.gita.newsapp.data.remote.response.ArticlesItem
import uz.gita.newsapp.databinding.ScreenNewsItemsBinding
import uz.gita.newsapp.presentation.ui.adapter.NewsListAdapter
import uz.gita.newsapp.presentation.viewmodel.UniversalScreenForNewsViewModel
import uz.gita.newsapp.presentation.viewmodel.implementations.UniversalScreenForNewsViewModelImpl

class UniversalScreenForNews : Fragment(R.layout.screen_news_items) {
    private val binding by viewBinding(ScreenNewsItemsBinding::bind)
    private val viewModel: UniversalScreenForNewsViewModel by viewModels<UniversalScreenForNewsViewModelImpl>()
    private val adapter by lazy { NewsListAdapter() }
    private val listItems = ArrayList<ArticlesItem>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.backLiveData.observe(viewLifecycleOwner,backObserver)
        viewModel.loadLiveData.observe(viewLifecycleOwner,loadObserver)
        viewModel.progressLiveData.observe(viewLifecycleOwner,progressObserver)
        viewModel.errorLiveData.observe(viewLifecycleOwner,errorObserver)
        binding.UnivNewsRV.adapter = adapter
        binding.UnivNewsRV.layoutManager = LinearLayoutManager(requireContext())
        viewModel.load(arguments?.getString("TYPE")!!)
        binding.search.addTextChangedListener{
            searchedText(it.toString())
        }

    }

    private fun searchedText(data: String){
        val list = ArrayList<ArticlesItem>()
        for(i in 0 until listItems.size){
            if(listItems[i].title!!.lowercase().contains(data.lowercase())){
                list.add(listItems[i])
            }
        }
        adapter.submitList(list)
    }

    private val backObserver = Observer<Unit>{
        findNavController().popBackStack()
    }

    private val loadObserver = Observer<List<ArticlesItem>>{
        listItems.addAll(it)
        adapter.submitList(it)
    }

    private val progressObserver = Observer<Boolean>{
        if(it) binding.progress.show()
        else binding.progress.hide()
    }

    private val errorObserver = Observer<String>{
        Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
    }
}