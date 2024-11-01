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
import androidx.navigation.NavController
import com.google.gson.Gson
import com.training.livecodingtest.data.model.UserUIModel
import com.training.livecodingtest.ui.navigation.Screens
import com.training.livecodingtest.ui.viewmodel.UserViewModel
import com.training.livecodingtest.ui.widgets.User
import com.training.livecodingtest.utils.NetworkResult

@Composable
fun MainScreen(navController: NavController, viewModel: UserViewModel) {
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
            ShowList(navController, userData.data)
        }
    }
}

@Composable
fun ShowList(navController: NavController, userList: List<UserUIModel>) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(userList) { item ->
            User(item) { userId ->
                val route = Screens.DetailScreen.name
                val selectedUser = userList.first { user -> user.id == userId }
                val jsonString = Gson().toJson(selectedUser)
                navController.navigate("$route?user=${jsonString}")
            }
        }
    }
}