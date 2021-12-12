package com.mahmoud_ashraf.home.domain.usecases

import com.mahmoud_ashraf.home.data.model.MoviesResponse
import com.mahmoud_ashraf.home.domain.repository.MoviesRepository
import javax.inject.Inject

class GetMoviesUseCase@Inject constructor(val repository: MoviesRepository) {

    suspend operator fun invoke(pageNumber: Int): MoviesResponse = repository.getMovies(pageNumber)

}