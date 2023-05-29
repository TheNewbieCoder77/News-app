package uz.gita.newsapp.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import uz.gita.newsapp.R
import uz.gita.newsapp.data.remote.response.ArticlesItem
import uz.gita.newsapp.databinding.ItemNewMessageBinding

class NewsListAdapter : ListAdapter<ArticlesItem, NewsListAdapter.NewsListViewHolder>(
    DFUtil
) {

    object DFUtil: DiffUtil.ItemCallback<ArticlesItem>(){
        override fun areItemsTheSame(oldItem: ArticlesItem, newItem: ArticlesItem): Boolean {
            return false
        }

        override fun areContentsTheSame(oldItem: ArticlesItem, newItem: ArticlesItem): Boolean {
            return oldItem == newItem
        }

    }

    inner class NewsListViewHolder(private val binding: ItemNewMessageBinding): RecyclerView.ViewHolder(binding.root){

        fun bind()= with(binding){
            val data = getItem(absoluteAdapterPosition)
            Picasso.get()
                .load(data.urlToImage)
                .into(imgId)

            tvTitle.text = data.title
            tvAuthor.text = data.author
            tvDescription.text = data.description
            tvLink.text = data.url
            tvPublishedAt.text = data.publishedAt
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsListAdapter.NewsListViewHolder {
        return NewsListViewHolder(ItemNewMessageBinding.bind(LayoutInflater.from(parent.context).inflate(R.layout.item_new_message,parent,false)))
    }

    override fun onBindViewHolder(holder: NewsListAdapter.NewsListViewHolder, position: Int) {
        holder.bind()
    }

}