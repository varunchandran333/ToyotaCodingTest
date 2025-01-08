package com.training.livecodingtest.domain.usecase

import com.training.livecodingtest.domain.model.UserDomainModel
import com.training.livecodingtest.utils.NetworkResult
import com.training.livecodingtest.utils.UserMapper
import kotlinx.coroutines.flow.Flow

class GetUserDataUseCase(private val userRepository: Repository) {
    operator fun invoke(): Flow<NetworkResult<List<UserDomainModel>>> =
        UserMapper.convertUserListFlow(userRepository.getUsers())
}