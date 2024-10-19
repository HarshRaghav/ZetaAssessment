package com.example.assessmentapplication.di

import android.content.Context
import com.example.assessmentapplication.MainActivity
import com.example.assessmentapplication.presentation.viewModel.MovieViewModel
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [MovieModule::class, ViewModelFactoryModule::class, AppModule::class, ViewModelModule::class])
interface AppComponent {

    @Component.Factory
    interface Factory{
        fun create(@BindsInstance applicationContext: Context): AppComponent
    }

    companion object{
        fun factory(): Factory = DaggerAppComponent.factory()
    }

    fun inject (activity: MainActivity)
}