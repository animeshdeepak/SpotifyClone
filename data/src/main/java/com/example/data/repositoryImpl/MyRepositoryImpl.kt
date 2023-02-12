package com.example.data.repositoryImpl

import com.example.data.AppAPI
import com.example.domain.AppConstant
import com.example.domain.models.MovieByIdResponse
import com.example.domain.repository.MyRepository

class MyRepositoryImpl(private val api: AppAPI) : MyRepository {
    override suspend fun getMovieDetailsById(id: String?): MovieByIdResponse {
        return api.getMovieDetailsById(AppConstant.BASE_URL, id)
    }
}