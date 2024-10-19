package com.example.assessmentapplication

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.assessmentapplication.presentation.state.MovieState
import com.example.assessmentapplication.presentation.viewModel.MovieViewModel
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        var viewModel = ViewModelProvider(this, viewModelFactory)[MovieViewModel::class.java]
        viewModel.state.observe(this){
            when (it){
                is MovieState.ShowError -> Toast.makeText(applicationContext, it.errorMsg, Toast.LENGTH_LONG).show()
                is MovieState.UpdateLoader -> Toast.makeText(applicationContext,"loader"+ it.show, Toast.LENGTH_LONG).show()
                is MovieState.UpdateMovieList -> Toast.makeText(applicationContext,it.data.size, Toast.LENGTH_LONG).show()
            }
        }

    }
}

