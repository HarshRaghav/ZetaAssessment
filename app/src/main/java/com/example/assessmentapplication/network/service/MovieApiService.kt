package com.example.assessmentapplication.network.service

import com.example.assessmentapplication.common.Constants
import com.example.assessmentapplication.data.model.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface MovieApiService {

    @GET(Constants.MOVIE_ENDPOINT)
    suspend fun getMovieList(
        @Header(Constants.AUTHORIZATION_HEADER_KEY) auth: String,
        @Header(Constants.ACCEPT_HEADER_KEY) accept: String,
        @Query(Constants.INCLUDE_ADULT_QUERY_KEY) includeAdult: Boolean,
        @Query("language") language: String,
        @Query("page") page: Int
    ): MovieResponse
}