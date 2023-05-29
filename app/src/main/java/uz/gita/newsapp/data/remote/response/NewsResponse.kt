package uz.gita.newsapp.data.remote.response

data class NewsResponse(
    val totalResults: Int? = null,
    val articles: List<ArticlesItem>,
    val status: String? = null
)
