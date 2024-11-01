package com.training.livecodingtest.data.model

data class UserDomainModel(
    val id: Int,
    val name: String,
    val imageUrl: String,
    val firstEpisodeAppearance: String,
    val voiceActor: String
)

data class UserUIModel(
    val id: Int,
    val displayName: String,
    val avatarUrl: String,
    val firstAppearance: String,
    val voiceInfo: String
)