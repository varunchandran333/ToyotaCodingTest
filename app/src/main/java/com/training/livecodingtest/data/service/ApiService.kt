package com.training.livecodingtest.data.service

import com.training.livecodingtest.data.model.UserListItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("characters/")
    suspend fun getUsers(
        @Query("limit") limit: Int = 9, @Query("skip") skip: Int = 6
    ): Response<List<UserListItem>>
}