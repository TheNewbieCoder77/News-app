package uz.gita.newsapp.data.remote.response

import com.google.gson.annotations.SerializedName

data class SourceResponse(

    @field:SerializedName("sources")
	val sources: List<SourcesItem?>? = null,

    @field:SerializedName("status")
	val status: String? = null
)