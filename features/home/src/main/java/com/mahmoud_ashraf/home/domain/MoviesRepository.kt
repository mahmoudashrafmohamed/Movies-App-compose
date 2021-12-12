package com.mahmoud_ashraf.home.domain

import com.mahmoud_ashraf.home.data.model.MoviesResponse

interface MoviesRepository {
    suspend fun getMovies(pageNumber: Int): MoviesResponse
}