package com.example.spotifyclone.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.MovieByIdResponse
import com.example.domain.repository.MyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val myRepository: MyRepository
) : ViewModel() {

    private val _response = MutableLiveData<MovieByIdResponse>()
    val response: LiveData<MovieByIdResponse>
        get() = _response

    fun callMovieDetailsById(id: String?) {
        viewModelScope.launch(Dispatchers.Main) {
            _response.value = myRepository.getMovieDetailsById(id)
        }
    }
}