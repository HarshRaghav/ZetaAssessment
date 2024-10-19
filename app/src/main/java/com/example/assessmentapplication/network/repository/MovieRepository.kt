package com.example.assessmentapplication.network.repository

import com.example.assessmentapplication.common.Constants.ACCEPT_HEADER_VALUE
import com.example.assessmentapplication.common.Constants.AUTHORIZATION_HEADER_VALUE
import com.example.assessmentapplication.data.Result
import com.example.assessmentapplication.data.model.MovieResponse
import com.example.assessmentapplication.network.service.MovieApiService
import com.example.assessmentapplication.data.model.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject


interface MovieRepository {
    suspend fun getMovieList(
        includeAdult: Boolean,
        language: String,
        page: Int
    ): Result<MovieResponse>
}

class MovieRepositoryImp @Inject constructor(private val apiService: MovieApiService): MovieRepository {
    override suspend fun getMovieList(
        includeAdult: Boolean,
        language: String,
        page: Int
    ): Result<MovieResponse> = withContext(Dispatchers.IO) {
        try {
            val result = apiService.getMovieList(
                AUTHORIZATION_HEADER_VALUE,
                ACCEPT_HEADER_VALUE,
                includeAdult,
                language,
                page
            )
            Result.Success(result)
        } catch (exception: Exception) {
            Result.Error(exception)
        }
    }
}
