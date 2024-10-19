package com.example.assessmentapplication

import android.app.Application
import com.example.assessmentapplication.di.AppComponent
import com.example.assessmentapplication.di.DaggerAppComponent

class MovieApplication: Application() {

    val appComponent: AppComponent by lazy{
        provideDaggerComponent()
    }

    private fun provideDaggerComponent(): AppComponent {
        return DaggerAppComponent.factory().create(applicationContext)
    }
}