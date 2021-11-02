package com.example.todojetpackcomposemvvm.navigation

import androidx.navigation.NavController
import com.example.todojetpackcomposemvvm.util.Action
import com.example.todojetpackcomposemvvm.util.Constants.LIST_SCREEN
import com.example.todojetpackcomposemvvm.util.Constants.SPLASH_SCREEN

class Screens(navController: NavController) {
    // Splash Navigates to ListScreen
    val splash: () -> Unit = {
        navController.navigate(route = "list/${Action.NO_ACTION.name}") {
            popUpTo(SPLASH_SCREEN) { inclusive = true }
        }
    }

    // List Navigates to TaskScreen
    val list: (Action) -> Unit = { action ->
        navController.navigate("list/${action.name}") {
            popUpTo(LIST_SCREEN) { inclusive = true }
        }
    }

    // Task Navigates back to ListScreen
    val task: (Int) -> Unit = { taskId ->
        navController.navigate("task/$taskId")
    }

}