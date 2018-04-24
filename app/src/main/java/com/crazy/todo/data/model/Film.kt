package com.crazy.todo.data.model

import com.google.gson.annotations.SerializedName

data class Film(
		@SerializedName("id") val id: String = "",
		@SerializedName("title") val title: String = "",
		@SerializedName("description") val description: String = "",
		@SerializedName("director") val director: String = "",
		@SerializedName("producer") val producer: String = "",
		@SerializedName("release_date") val releaseDate: String = "",
		@SerializedName("rt_score") val rtScore: String = "",
		@SerializedName("url") val url: String = "",
        @SerializedName("favourite") var favourite: Boolean = false
)