package com.training.livecodingtest.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.training.livecodingtest.domain.UserUIModel
import com.training.livecodingtest.ui.screens.DetailScreen
import com.training.livecodingtest.ui.screens.MainScreen
import com.training.livecodingtest.ui.viewmodel.UserViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun UserNavigation() {
    val navController = rememberNavController()
    val viewModel = koinViewModel<UserViewModel>()
    NavHost(navController, startDestination = Main) {
        composable<Main> {
            MainScreen(viewModel) { user ->
                navController.navigate(Detail(user))
            }
        }
        composable<Detail>(typeMap = UserUIModel.typeMap) { navBack ->
            val receivedData = navBack.toRoute<Detail>().userUIModel
            DetailScreen(receivedData)
        }
    }
}