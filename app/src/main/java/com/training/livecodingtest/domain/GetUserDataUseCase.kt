package com.training.livecodingtest.domain

import com.training.livecodingtest.data.model.UserDomainModel
import com.training.livecodingtest.data.repository.Repository
import com.training.livecodingtest.utils.NetworkResult
import com.training.livecodingtest.utils.UserMapper
import kotlinx.coroutines.flow.Flow

class GetUserDataUseCase(private val userRepository: Repository) {
    operator fun invoke(): Flow<NetworkResult<List<UserDomainModel>>> =
        UserMapper.convertUserListFlow(userRepository.getUsers())
}