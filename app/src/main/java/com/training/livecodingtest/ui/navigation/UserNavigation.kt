package com.training.livecodingtest.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.google.gson.Gson
import com.training.livecodingtest.data.model.UserListItem
import com.training.livecodingtest.data.model.UserUIModel
import com.training.livecodingtest.ui.screens.DetailScreen
import com.training.livecodingtest.ui.screens.MainScreen
import com.training.livecodingtest.ui.viewmodel.UserViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun UserNavigation() {
    val navController = rememberNavController()
    val viewModel = koinViewModel<UserViewModel>()
    NavHost(navController, startDestination = Screens.MainScreen.name) {
        composable(Screens.MainScreen.name) {
            MainScreen(navController, viewModel)
        }
        val route = Screens.DetailScreen.name
        composable("$route?user={user}", arguments = listOf(
            navArgument("user") {
                type = NavType.StringType
            }
        )) { navBack ->
            val receivedData = navBack.arguments?.getString("user")
            val sentData = Gson().fromJson(receivedData, UserUIModel::class.java)
            DetailScreen(sentData)
        }
    }
}