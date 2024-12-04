package com.training.livecodingtest.domain

import android.os.Parcelable
import eu.anifantakis.navhelper.serialization.StringSanitizer
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class UserUIModel(
    val id: Int,
    val displayName: String,
    @Serializable(with = StringSanitizer::class)
    val avatarUrl: String,
    val firstAppearance: String,
    val voiceInfo: String
) : Parcelable