package com.training.livecodingtest.domain

import com.training.livecodingtest.data.model.UserUIModel
import com.training.livecodingtest.utils.NetworkResult
import com.training.livecodingtest.utils.UserMapper
import kotlinx.coroutines.flow.Flow

class UserDomainWrapper(
    private val getUserDataUseCase: GetUserDataUseCase
) {
    fun fetchUser(): Flow<NetworkResult<List<UserUIModel>>> =
        UserMapper.convertUserListFlowToUiList(getUserDataUseCase())
}