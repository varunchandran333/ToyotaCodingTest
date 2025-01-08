package com.training.livecodingtest.ui.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.training.livecodingtest.domain.model.UserUIModel
import com.training.livecodingtest.ui.viewmodel.UserViewModel
import com.training.livecodingtest.ui.components.User
import com.training.livecodingtest.utils.NetworkResult

@Composable
fun MainScreen(viewModel: UserViewModel, onItemClick: (UserUIModel) -> Unit) {
    val receivedData = viewModel.userData.collectAsStateWithLifecycle()
    val context = LocalContext.current
    when (val userData = receivedData.value) {
        is NetworkResult.Error -> {
            Toast.makeText(context, userData.message, Toast.LENGTH_SHORT).show()
        }

        is NetworkResult.Loading -> {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CircularProgressIndicator()
            }
        }

        is NetworkResult.Success -> {
            ShowList(userData.data) { id ->
                onItemClick(id)
            }
        }
    }
}

@Composable
fun ShowList(userList: List<UserUIModel>, onItemClick: (UserUIModel) -> Unit) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(items = userList, key = { item -> item.id }) { item ->
            User(item) { user ->
                onItemClick(user)
            }
        }
    }
}