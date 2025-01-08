package com.training.livecodingtest.domain.wrapper

import com.training.livecodingtest.domain.model.UserUIModel
import com.training.livecodingtest.domain.usecase.GetUserDataUseCase
import com.training.livecodingtest.utils.NetworkResult
import com.training.livecodingtest.utils.UserMapper
import kotlinx.coroutines.flow.Flow

class UserDomainWrapper(
    private val getUserDataUseCase: GetUserDataUseCase
) {
    operator fun invoke(): Flow<NetworkResult<List<UserUIModel>>> =
        UserMapper.convertUserListFlowToUiList(getUserDataUseCase())
}