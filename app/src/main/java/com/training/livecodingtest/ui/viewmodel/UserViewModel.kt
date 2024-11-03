package com.training.livecodingtest.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.training.livecodingtest.domain.UserDomainWrapper
import com.training.livecodingtest.utils.NetworkResult
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn

class UserViewModel(userDomainWrapper: UserDomainWrapper) : ViewModel() {
    val userData = userDomainWrapper().stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000),
        NetworkResult.Loading
    )
}