package com.training.livecodingtest.domain

import com.training.livecodingtest.ui.navigation.serializableType
import kotlinx.serialization.Serializable
import kotlin.reflect.typeOf

@Serializable
data class UserUIModel(
    val id: Int,
    val displayName: String,
    @Serializable(with = UrlEncodedStringSerializer::class)
    val avatarUrl: String,
    val firstAppearance: String,
    val voiceInfo: String
) {
    companion object {
        val typeMap = mapOf(typeOf<UserUIModel>() to serializableType<UserUIModel>())
    }
}