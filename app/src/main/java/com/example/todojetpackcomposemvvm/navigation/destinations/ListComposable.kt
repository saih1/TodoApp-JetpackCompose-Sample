package com.example.todojetpackcomposemvvm.navigation.destinations

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.todojetpackcomposemvvm.ui.screens.list.ListScreen
import com.example.todojetpackcomposemvvm.ui.viewmodels.SharedViewModel
import com.example.todojetpackcomposemvvm.util.Constants.LIST_ARGUMENT_KEY
import com.example.todojetpackcomposemvvm.util.Constants.LIST_SCREEN

// Extension function on NavGraphBuilder
fun NavGraphBuilder.listComposable(
    navigateToTaskScreen: (Int) -> Unit,
    sharedViewModel: SharedViewModel
) {
    composable(
        route = LIST_SCREEN,
        arguments = listOf(navArgument(LIST_ARGUMENT_KEY) {
            type = NavType.StringType
        })
    ) {
        ListScreen(
            navigateToTaskScreen = navigateToTaskScreen,
            sharedViewModel = sharedViewModel
        )
    }
}