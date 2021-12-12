package com.mahmoud_ashraf.home.data.repository.remote

import com.mahmoud_ashraf.home.data.model.MoviesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieAPI {
    @GET("/3/movie/popular?api_key=6fd435cb71362c657e45c6cd8a5c0510")
    suspend fun getMovies(@Query("page") pageNumber: Int): MoviesResponse
}