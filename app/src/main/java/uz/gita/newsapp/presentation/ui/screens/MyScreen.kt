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
import uz.gita.newsapp.databinding.MyNewsItemsBinding
import uz.gita.newsapp.presentation.ui.adapter.NewsListAdapter
import uz.gita.newsapp.presentation.viewmodel.MyScreenViewModel
import uz.gita.newsapp.presentation.viewmodel.implementations.MyScreenViewModelImpl

class MyScreen : Fragment(R.layout.my_news_items) {
    private val binding by viewBinding(MyNewsItemsBinding::bind)
    private val viewModel: MyScreenViewModel by viewModels<MyScreenViewModelImpl>()
    private val adapter by lazy { NewsListAdapter() }
    private val listItems = ArrayList<ArticlesItem>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.MyNewsRV.adapter = adapter
        binding.MyNewsRV.layoutManager = LinearLayoutManager(requireContext())
        viewModel.backLiveData.observe(viewLifecycleOwner,backObserver)
        viewModel.errorLiveData.observe(viewLifecycleOwner,errorObserver)
        viewModel.progressLiveData.observe(viewLifecycleOwner,progressObserver)
        viewModel.loadLiveData.observe(viewLifecycleOwner,loadObserver)
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

    private val errorObserver = Observer<String>{
        Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
    }

    private val progressObserver = Observer<Boolean>{
        if(it) binding.progress.show()
        else binding.progress.hide()
    }

    private val loadObserver = Observer<List<ArticlesItem>>{
        listItems.addAll(it)
        adapter.submitList(it)
    }
}