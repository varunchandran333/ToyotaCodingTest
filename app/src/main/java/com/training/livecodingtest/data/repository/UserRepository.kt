package com.training.livecodingtest.data.repository

import com.training.livecodingtest.data.newModel.Users
import com.training.livecodingtest.data.service.ApiService
import com.training.livecodingtest.domain.Repository
import com.training.livecodingtest.utils.NetworkResult
import com.training.livecodingtest.utils.handleApi
import kotlinx.coroutines.flow.Flow

class UserRepository(private val apiService: ApiService) : Repository {
    override fun getUsers(): Flow<NetworkResult<Users>> = handleApi {
        apiService.getUsers()
    }
}