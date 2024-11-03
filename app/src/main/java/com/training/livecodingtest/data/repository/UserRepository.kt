package com.training.livecodingtest.data.repository

import com.training.livecodingtest.data.model.UserListItem
import com.training.livecodingtest.data.service.ApiService
import com.training.livecodingtest.utils.NetworkResult
import com.training.livecodingtest.utils.handleApi
import kotlinx.coroutines.flow.Flow

class UserRepository(private val apiService: ApiService) : Repository {
    override fun getUsers(): Flow<NetworkResult<List<UserListItem>>> = handleApi {
        apiService.getUsers()
    }
}