package com.mahmoud_ashraf.home.data.repository

import com.mahmoud_ashraf.home.data.model.MoviesResponse
import com.mahmoud_ashraf.home.data.repository.remote.MovieAPI
import com.mahmoud_ashraf.home.domain.MoviesRepository
import javax.inject.Inject

class MoviesRepositoryImpl
@Inject
constructor(
    private val remote: MovieAPI
) : MoviesRepository {

    override
    suspend fun getMovies(pageNumber: Int): MoviesResponse {
        return remote.getMovies(pageNumber)
    }
}