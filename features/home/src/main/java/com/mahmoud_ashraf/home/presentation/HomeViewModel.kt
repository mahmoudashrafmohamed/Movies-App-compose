package com.mahmoud_ashraf.home.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mahmoud_ashraf.home.data.model.MoviesResponse
import com.mahmoud_ashraf.home.domain.usecases.GetMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(val getMoviesUseCase: GetMoviesUseCase) : ViewModel() {

     val uiState = MutableLiveData<ResultStates>()

    init {
        fetch()
    }

    fun fetch() = viewModelScope.launch(Dispatchers.IO) {
        runCatching {
            uiState.postValue(ResultStates.Loading)
            getMoviesUseCase(6)
        }.onSuccess { data ->
            uiState.postValue(ResultStates.Success(data))
        }.onFailure { t ->
            uiState.postValue(ResultStates.Error(t))
            t.printStackTrace()
        }

    }
}

sealed class ResultStates {
    object Loading : ResultStates()
    data class Success(val movies: MoviesResponse) : ResultStates()
    data class Error(val error: Throwable) : ResultStates()
}