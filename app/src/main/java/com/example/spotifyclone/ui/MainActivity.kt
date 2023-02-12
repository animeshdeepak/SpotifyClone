package com.example.spotifyclone.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.domain.AppConstant
import com.example.spotifyclone.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "MainActivity"
    }

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()

        observers()
    }

    private fun initViews() {
        binding.callApiBtn.setOnClickListener {
            Toast.makeText(this, "btn click", Toast.LENGTH_SHORT).show()
            viewModel.callMovieDetailsById(AppConstant.DUMMY_MOVIE_ID)
        }
    }

    private fun observers() {
        viewModel.apply {
            response.observe(this@MainActivity) { model ->
                Toast.makeText(
                    this@MainActivity,
                    "actors: ${model.actors} awards: ${model.awards}",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }
}