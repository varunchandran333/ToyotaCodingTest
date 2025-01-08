package com.training.livecodingtest.domain.model

data class UserDomainModel(
    val id: Int,
    val name: String,
    val imageUrl: String,
    val firstEpisodeAppearance: String,
    val voiceActor: String
)

