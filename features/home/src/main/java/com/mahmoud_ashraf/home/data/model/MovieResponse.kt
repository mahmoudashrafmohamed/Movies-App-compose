package com.mahmoud_ashraf.home.data.model

import com.google.gson.annotations.SerializedName

data class MoviesResponse(

    @SerializedName("page")
    val page: Int? = null,

    @SerializedName("total_pages")
    val totalPages: Int? = null,

    @SerializedName("results")
    val results: List<Movie>? = null,

    @SerializedName("total_results")
    val totalResults: Int? = null
)
data class Movie(

    @SerializedName("id")
    val id: Int? = null,

    @SerializedName("overview")
    val overview: String? = null,

    @SerializedName("title")
    val title: String? = null,

    @SerializedName("release_date")
    val releaseDate: String? = null,

    @SerializedName("backdrop_path")
    val backdropPath: String? = null,

    @SerializedName("poster_path")
    val poster_path: String? = null,

)