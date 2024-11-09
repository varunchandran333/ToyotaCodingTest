package com.training.livecodingtest.domain

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.toRoute
import com.training.livecodingtest.ui.navigation.serializableType
import kotlinx.serialization.Serializable
import kotlin.reflect.typeOf

@Serializable
data class UserUIModel(
    val id: Int,
    val displayName: String,
    val avatarUrl: String,
    val firstAppearance: String,
    val voiceInfo: String
) {
    companion object {
        val typeMap = mapOf(typeOf<UserUIModel>() to serializableType<UserUIModel>())

        fun from(savedStateHandle: SavedStateHandle) =
            savedStateHandle.toRoute<UserUIModel>(typeMap)
    }
}