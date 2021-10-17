package com.example.todojetpackcomposemvvm.navigation

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.todojetpackcomposemvvm.navigation.destinations.listComposable
import com.example.todojetpackcomposemvvm.navigation.destinations.taskComposable
import com.example.todojetpackcomposemvvm.ui.viewmodels.SharedViewModel
import com.example.todojetpackcomposemvvm.util.Constants.LIST_SCREEN

@ExperimentalMaterialApi
@Composable
fun SetupNavigation(
    navController: NavHostController,
    sharedViewModel: SharedViewModel
) {
    // save backstack
    val screen = remember(navController) {
        Screens(navController = navController)
    }

//    NavHost(
//        navController = navController,
//        startDestination = LIST_SCREEN
//    ) {
//        listComposable(
//            navigateToTaskScreen = screen.task,
//            sharedViewModel = sharedViewModel
//        )
//        taskComposable(
//            navigateToListScreen = screen.list
//        )
//    }

    NavHost(navController = navController, startDestination = LIST_SCREEN) {
        listComposable(navigateToTaskScreen = screen.task, sharedViewModel = sharedViewModel)
        taskComposable(navigateToListScreen = screen.list)
    }
}