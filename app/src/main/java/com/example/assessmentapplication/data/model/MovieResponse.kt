package com.example.assessmentapplication.data.model

data class MovieResponse(
    val page: Int,
    val result: List<Movie>,
    val total_pages: Int,
    val total_results: Int
)