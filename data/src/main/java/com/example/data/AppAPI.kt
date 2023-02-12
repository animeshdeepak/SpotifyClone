package com.example.data

import com.example.domain.AppConstant
import com.example.domain.models.MovieByIdResponse
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url


interface AppAPI {

    @GET
    suspend fun getMovieDetailsById(
        @Url url: String,
        @Query(AppConstant.QUERY_MOVIE_ID) id: String?
    ): MovieByIdResponse
}