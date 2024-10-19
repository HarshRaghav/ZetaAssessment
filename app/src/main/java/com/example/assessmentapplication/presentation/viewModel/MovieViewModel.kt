package com.example.assessmentapplication.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.assessmentapplication.data.Result
import com.example.assessmentapplication.network.repository.MovieRepository
import com.example.assessmentapplication.presentation.state.MovieState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MovieViewModel @Inject constructor(private val repository: MovieRepository): ViewModel() {
    private var _state = MutableLiveData<MovieState>()
    var state: LiveData<MovieState> = _state

    init{
        //get data on viewModelCreation then add getMovie() call here
    }
    private fun getMovie(){
        viewModelScope.launch {
            updateMovieScreen(MovieState.UpdateLoader(true))
            var result = repository.getMovieList(false, "en-US", 1)

            when(result){
                is Result.Success -> {
                    updateMovieScreen(MovieState.UpdateMovieList(result.data.result))

                    updateMovieScreen(MovieState.UpdateLoader(show = false))
                }
                is Result.Error -> {
                    updateMovieScreen(MovieState.ShowError(result.exception.message))
                    updateMovieScreen(MovieState.UpdateLoader(show = false))
                }
            }
        }

    }

    private suspend fun updateMovieScreen(movieState: MovieState){
        withContext(Dispatchers.Main) {
            _state.postValue(movieState)
        }
    }

}