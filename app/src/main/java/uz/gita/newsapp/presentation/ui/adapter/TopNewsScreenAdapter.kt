package uz.gita.newsapp.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import uz.gita.newsapp.R
import uz.gita.newsapp.databinding.ItemTopNewsNameBinding

class TopNewsScreenAdapter : ListAdapter<String,TopNewsScreenAdapter.TPNViewHolder>(DfUtil) {
    private var itemClickedListener: ((String)-> Unit)? = null

    fun setItemClickedListener(f: (String)-> Unit){
        itemClickedListener = f
    }
    object DfUtil: DiffUtil.ItemCallback<String>(){
        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
            return false
        }

        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }

    }

    inner class TPNViewHolder(private val binding: ItemTopNewsNameBinding): RecyclerView.ViewHolder(binding.root){
        init{
            binding.myId.setOnClickListener{
                itemClickedListener?.invoke(getItem(absoluteAdapterPosition))
            }
        }
        fun bind(){
            binding.nameId.text = getItem(absoluteAdapterPosition)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TPNViewHolder {
        return TPNViewHolder(ItemTopNewsNameBinding.bind(LayoutInflater.from(parent.context).inflate(R.layout.item_top_news_name,parent,false)))
    }

    override fun onBindViewHolder(holder: TPNViewHolder, position: Int) {
        holder.bind()
    }


}