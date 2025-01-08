package com.training.livecodingtest.domain.usecase

import com.training.livecodingtest.data.newModel.Users
import com.training.livecodingtest.utils.NetworkResult
import kotlinx.coroutines.flow.Flow

interface Repository {
    fun getUsers(): Flow<NetworkResult<Users>>
}