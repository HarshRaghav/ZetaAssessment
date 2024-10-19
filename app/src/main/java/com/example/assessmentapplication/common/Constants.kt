package com.example.assessmentapplication.common

object Constants {

    const val MOVIE_BASE_URL = "https://api.themoviedb.org/3/discover/"
    const val MOVIE_ENDPOINT = "tv"

    const val AUTHORIZATION_HEADER_KEY = "Authorization"
    const val AUTHORIZATION_HEADER_VALUE = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJjYTgyZDE0ZDE3Y2JlYjRmZGMzN2I5MTYyMDNhNzRjYSIsIm5iZiI6MTcyOTE1ODg0Ni4xMjIyOTQsInN1YiI6IjY3MGUzM2ZiMGI4MDA1MzdkNzVjZGE5NyIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.WJD47QmKbzlZG6Y_5byzzMLOzmAv21BYI9UP6vDklb0"

    const val ACCEPT_HEADER_KEY = "accept"
    const val ACCEPT_HEADER_VALUE = "application/json"

    const val INCLUDE_ADULT_QUERY_KEY = "include_adult"
    const val INCLUDE_ADULT_QUERY_VALUE = "include_adult"

}

//curl --request GET \
//--url 'https://api.themoviedb.org/3/discover/tv?include_adult=false&language=en-US&page=1&sort_by=vote_average.desc&vote_count.gte=200' \
//--header 'Authorization: Bearer ACCESS_TOKEN' \
//--header 'accept: application/json'
//
//https://api.themoviedb.org/3/discover/
//tv
