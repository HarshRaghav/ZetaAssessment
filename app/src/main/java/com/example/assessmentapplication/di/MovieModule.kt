package com.example.assessmentapplication.di

import com.example.assessmentapplication.network.repository.MovieRepository
import com.example.assessmentapplication.network.repository.MovieRepositoryImp
import dagger.Binds
import dagger.Module

@Module
abstract class MovieModule {

    @Binds
    abstract fun provideRepo(movieRepo: MovieRepositoryImp): MovieRepository
}