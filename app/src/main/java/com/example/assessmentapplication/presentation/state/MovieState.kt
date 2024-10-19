package com.example.assessmentapplication.presentation.state

import com.example.assessmentapplication.data.model.Movie

sealed class MovieState {
    data class UpdateMovieList(val data: List<Movie>): MovieState()
    data class ShowError(val errorMsg: String?): MovieState()
    data class UpdateLoader(val show: Boolean? = false): MovieState()

}