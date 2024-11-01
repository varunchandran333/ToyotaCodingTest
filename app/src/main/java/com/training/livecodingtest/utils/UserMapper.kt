package com.training.livecodingtest.utils

import com.training.livecodingtest.data.model.UserDomainModel
import com.training.livecodingtest.data.model.UserListItem
import com.training.livecodingtest.data.model.UserUIModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

object UserMapper {

    private fun toDomain(dataModel: UserListItem): UserDomainModel {
        return UserDomainModel(
            id = dataModel.id,
            name = dataModel.name,
            imageUrl = dataModel.image,
            firstEpisodeAppearance = dataModel.firstEpisode,
            voiceActor = dataModel.voicedBy
        )
    }

    fun convertUserListFlow(
        inputFlow: Flow<NetworkResult<List<UserListItem>>>
    ): Flow<NetworkResult<List<UserDomainModel>>> {
        return inputFlow.map { networkResult ->
            when (networkResult) {
                is NetworkResult.Success -> {
                    val domainModels = toDomainList(networkResult.data)
                    NetworkResult.Success(domainModels)
                }

                is NetworkResult.Error -> {
                    NetworkResult.Error(networkResult.code, networkResult.message)
                }

                is NetworkResult.Loading -> {
                    NetworkResult.Loading
                }
            }
        }
    }

    // List of User Data Models to List of Domain Models
    private fun toDomainList(dataModelList: List<UserListItem>): List<UserDomainModel> {
        return dataModelList.map { toDomain(it) }
    }

    // Domain Model to UI Model
    private fun toUI(domainModel: UserDomainModel): UserUIModel {
        return UserUIModel(
            displayName = domainModel.name,
            avatarUrl = domainModel.imageUrl,
            firstAppearance = "First appeared in: ${domainModel.firstEpisodeAppearance}",
            voiceInfo = "Voiced by: ${domainModel.voiceActor}",
            id = domainModel.id
        )
    }

    fun convertUserListFlowToUiList(
        inputFlow: Flow<NetworkResult<List<UserDomainModel>>>
    ): Flow<NetworkResult<List<UserUIModel>>> {
        return inputFlow.map { networkResult ->
            when (networkResult) {
                is NetworkResult.Success -> {
                    val uiModels = toUIList(networkResult.data)
                    NetworkResult.Success(uiModels)
                }

                is NetworkResult.Error -> {
                    NetworkResult.Error(networkResult.code, networkResult.message)
                }

                is NetworkResult.Loading -> {
                    NetworkResult.Loading
                }
            }
        }
    }

    // List of User Data Models to List of Domain Models
    private fun toUIList(dataModelList: List<UserDomainModel>): List<UserUIModel> {
        return dataModelList.map { toUI(it) }
    }
}