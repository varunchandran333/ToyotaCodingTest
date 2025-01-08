package com.training.livecodingtest.utils

import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.intl.Locale
import com.training.livecodingtest.domain.model.UserDomainModel
import com.training.livecodingtest.data.model.UserListItem
import com.training.livecodingtest.data.newModel.Users
import com.training.livecodingtest.domain.model.UserUIModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

object UserMapper {

    private fun toDomain(dataModel: UserListItem) = UserDomainModel(
        id = dataModel.id,
        name = dataModel.lastName,
        imageUrl = dataModel.image,
        firstEpisodeAppearance = dataModel.firstName,
        voiceActor = dataModel.gender
    )


    // List of User Data Models to List of Domain Models
    private fun toDomainList(dataModelList: Users) = dataModelList.users.map { toDomain(it) }


    fun convertUserListFlow(
        inputFlow: Flow<NetworkResult<Users>>
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
        firstAppearance = "First Name: ${domainModel.firstEpisodeAppearance}",
        voiceInfo = "Gender: ${domainModel.voiceActor.capitalize(Locale.current)}",
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
