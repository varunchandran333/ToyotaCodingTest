package com.training.livecodingtest.ui.navigation

import com.training.livecodingtest.domain.UserUIModel
import kotlinx.serialization.Serializable


@Serializable
object Main

@Serializable
data class Detail(val userUIModel: UserUIModel)