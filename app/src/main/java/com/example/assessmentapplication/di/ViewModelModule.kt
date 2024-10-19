package com.example.assessmentapplication.di

import androidx.lifecycle.ViewModel
import com.example.assessmentapplication.presentation.viewModel.MovieViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MovieViewModel::class)
    abstract fun provideViewModel(viewModel: MovieViewModel): ViewModel
}