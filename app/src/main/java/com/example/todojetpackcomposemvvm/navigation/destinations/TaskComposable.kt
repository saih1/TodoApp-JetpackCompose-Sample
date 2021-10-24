package com.example.todojetpackcomposemvvm.navigation.destinations

import android.util.Log
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.todojetpackcomposemvvm.ui.screens.task.TaskScreen
import com.example.todojetpackcomposemvvm.ui.viewmodels.SharedViewModel
import com.example.todojetpackcomposemvvm.util.Action
import com.example.todojetpackcomposemvvm.util.Constants
import com.example.todojetpackcomposemvvm.util.Constants.TASK_ARGUMENT_KEY

// Extension function on NavGraphBuilder
fun NavGraphBuilder.taskComposable(
    sharedViewModel: SharedViewModel,
    navigateToListScreen: (Action) -> Unit
) {
    composable(
        route = Constants.TASK_SCREEN,
        arguments = listOf(
            navArgument(Constants.TASK_ARGUMENT_KEY) {
                type = NavType.IntType
            }
        )
    ) { navBackStackEntry ->
        val taskId = navBackStackEntry.arguments!!.getInt(TASK_ARGUMENT_KEY)
        sharedViewModel.getSelectedTask(taskId = taskId)
        val selectedTask by sharedViewModel.selectedTask.collectAsState()

        TaskScreen(
            selectedTask = selectedTask,
            navigateToListScreen = navigateToListScreen
        )
    }
}