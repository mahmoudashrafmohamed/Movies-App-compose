package com.mahmoud_ashraf.home.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mahmoud_ashraf.home.domain.MoviesRepository
import com.mahmoud_ashraf.home.domain.usecases.GetMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(val getMoviesUseCase: GetMoviesUseCase) : ViewModel() {

    private val _message = MutableLiveData("Hi")
    val message: LiveData<String> = _message

    fun fetch()= viewModelScope.launch {
        getMoviesUseCase(10)
    }
}