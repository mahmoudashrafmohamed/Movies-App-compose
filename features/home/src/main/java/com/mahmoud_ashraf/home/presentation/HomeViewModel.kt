package com.mahmoud_ashraf.home.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mahmoud_ashraf.home.domain.MoviesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(val repository: MoviesRepository) : ViewModel() {
    fun fetch()= viewModelScope.launch {
        repository.getMovies(12)
    }
}