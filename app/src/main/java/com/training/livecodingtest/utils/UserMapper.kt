package com.training.livecodingtest.utils

import com.training.livecodingtest.domain.UserDomainModel
import com.training.livecodingtest.data.model.UserListItem
import com.training.livecodingtest.domain.UserUIModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

object UserMapper {

    private fun toDomain(dataModel: UserListItem) = UserDomainModel(
        id = dataModel.id,
        name = dataModel.name,
        imageUrl = dataModel.image,
        firstEpisodeAppearance = dataModel.firstEpisode,
        voiceActor = dataModel.voicedBy
    )


    // List of User Data Models to List of Domain Models
    private fun toDomainList(dataModelList: List<UserListItem>) = dataModelList.map { toDomain(it) }


    fun convertUserListFlow(
        inputFlow: Flow<NetworkResult<List<UserListItem>>>
    ) = inputFlow.map { networkResult ->
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


    // Domain Model to UI Model
    private fun toUI(domainModel: UserDomainModel) = UserUIModel(
        displayName = domainModel.name,
        avatarUrl = domainModel.imageUrl,
        firstAppearance = "First appeared in: ${domainModel.firstEpisodeAppearance}",
        voiceInfo = "Voiced by: ${domainModel.voiceActor}",
        id = domainModel.id
    )

    // List of User Data Models to List of Domain Models
    private fun toUIList(dataModelList: List<UserDomainModel>) = dataModelList.map { toUI(it) }

    fun convertUserListFlowToUiList(
        inputFlow: Flow<NetworkResult<List<UserDomainModel>>>
    ) = inputFlow.map { networkResult ->
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
