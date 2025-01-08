package com.training.livecodingtest.ui.screens

import androidx.compose.runtime.Composable
import com.training.livecodingtest.domain.model.UserUIModel
import com.training.livecodingtest.ui.components.UserDetails

@Composable
fun DetailScreen(userListItem: UserUIModel) {
    UserDetails(userListItem)
}