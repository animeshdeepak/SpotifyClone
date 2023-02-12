package com.example.domain.repository

import com.example.domain.models.MovieByIdResponse

interface MyRepository {
    suspend fun getMovieDetailsById(id: String?): MovieByIdResponse
}