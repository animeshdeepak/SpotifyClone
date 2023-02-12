package com.example.spotifyclone.ui

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import base.BaseActivity
import com.example.domain.AppConstant
import com.example.spotifyclone.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {

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

    override fun initViews() {
        binding.apply {
            callApiBtn.setOnClickListener {
                Toast.makeText(this@MainActivity, "btn click", Toast.LENGTH_SHORT).show()
                viewModel.callMovieDetailsById(AppConstant.DUMMY_MOVIE_ID)
            }

            saveBtn.setOnClickListener {
                viewModel.saveValueToPref("TEST_KEY", "DPK")
            }

            getBtn.setOnClickListener {
                val value: String? = viewModel.getStringValueFromPref("TEST_KEY")
                Toast.makeText(this@MainActivity, value ?: "NULL", Toast.LENGTH_SHORT).show()
                Log.d(TAG, value ?: "NULL")
            }
        }
    }

    override fun observers() {
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