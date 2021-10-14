package com.example.todojetpackcomposemvvm.navigation.destinations

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.todojetpackcomposemvvm.util.Action
import com.example.todojetpackcomposemvvm.util.Constants

// Extension function on NavGraphBuilder
fun NavGraphBuilder.taskComposable(
    navigateToListScreen: (Action) -> Unit
) {
    composable(
        route = Constants.TASK_SCREEN,
        arguments = listOf(
            navArgument(Constants.TASK_ARGUMENT_KEY) {
                type = NavType.IntType
            }
        )
    ) {

    }
}