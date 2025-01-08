package com.training.livecodingtest.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.training.livecodingtest.domain.model.UserUIModel
import com.training.livecodingtest.ui.screens.DetailScreen
import com.training.livecodingtest.ui.screens.MainScreen
import com.training.livecodingtest.ui.viewmodel.UserViewModel
import eu.anifantakis.navhelper.navtype.mapper
import org.koin.androidx.compose.koinViewModel
import kotlin.reflect.typeOf

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
        composable<Detail>(typeMap = mapOf(typeOf<UserUIModel>() to NavType.mapper<UserUIModel>())) { navBack ->
            val receivedData = rememberSaveable { navBack.toRoute<Detail>().userUIModel }
            DetailScreen(receivedData)
        }
    }
}