package com.training.livecodingtest.domain

import com.training.livecodingtest.data.model.UserListItem
import com.training.livecodingtest.utils.NetworkResult
import kotlinx.coroutines.flow.Flow

interface Repository {
    fun getUsers(): Flow<NetworkResult<List<UserListItem>>>
}