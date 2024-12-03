package com.training.livecodingtest.data.service

import com.training.livecodingtest.data.newModel.Users
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("users")
    suspend fun getUsers(): Response<Users>
}