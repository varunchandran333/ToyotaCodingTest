package com.training.livecodingtest.ui.screens

import androidx.compose.runtime.Composable
import com.training.livecodingtest.data.model.UserUIModel
import com.training.livecodingtest.ui.widgets.UserDetails

@Composable
fun DetailScreen(userListItem: UserUIModel) {
    UserDetails(userListItem)
}