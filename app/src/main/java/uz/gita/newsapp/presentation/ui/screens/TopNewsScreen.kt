package uz.gita.newsapp.presentation.ui.screens

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.gita.newsapp.R
import uz.gita.newsapp.databinding.ScreenTopNewsBinding
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import uz.gita.newsapp.presentation.ui.adapter.TopNewsScreenAdapter
import uz.gita.newsapp.presentation.viewmodel.TopNewsScreenViewModel
import uz.gita.newsapp.presentation.viewmodel.implementations.TopNewsScreenViewModelImpl

class TopNewsScreen : Fragment(R.layout.screen_top_news){
    private val binding by viewBinding(ScreenTopNewsBinding::bind)
    private val viewModel: TopNewsScreenViewModel by viewModels<TopNewsScreenViewModelImpl>()
    private val adapter by lazy { TopNewsScreenAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.openNewsLiveData.observe(this,openNewsObserver)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.topNewsRV.adapter = adapter
        binding.topNewsRV.layoutManager = GridLayoutManager(requireContext(),2)
        viewModel.load(arguments?.getString("LANGUAGE")!!)
        viewModel.loadLiveData.observe(viewLifecycleOwner,loadObserver)
        viewModel.backLiveData.observe(viewLifecycleOwner,backObserver)
        clickEvents()
    }

    private fun clickEvents(){
        binding.btnBack.setOnClickListener{
            viewModel.back()
        }
        adapter.setItemClickedListener {
            viewModel.openNews(it)
        }
    }

    private val openNewsObserver = Observer<String>{
        val bundle = Bundle()
        bundle.putString("TYPE",it)
        findNavController().navigate(R.id.action_topNewsScreen_to_universalScreenForNews,bundle)
    }

    private val loadObserver = Observer<List<String>>{
        adapter.submitList(it)
    }

    private val backObserver = Observer<Unit>{
        findNavController().popBackStack()
    }

}