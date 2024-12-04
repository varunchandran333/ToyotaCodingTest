package com.training.livecodingtest.data.newModel

import com.training.livecodingtest.data.model.UserListItem

data class Users(
    val limit: Int,
    val skip: Int,
    val total: Int,
    val users: List<UserListItem>
)