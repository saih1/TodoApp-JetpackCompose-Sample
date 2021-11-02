package com.example.todojetpackcomposemvvm.navigation.destinations

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.google.accompanist.navigation.animation.composable
import com.example.todojetpackcomposemvvm.ui.screens.list.ListScreen
import com.example.todojetpackcomposemvvm.ui.viewmodels.SharedViewModel
import com.example.todojetpackcomposemvvm.util.Action
import com.example.todojetpackcomposemvvm.util.Constants.LIST_ARGUMENT_KEY
import com.example.todojetpackcomposemvvm.util.Constants.LIST_SCREEN
import com.example.todojetpackcomposemvvm.util.toAction

// Extension function on NavGraphBuilder
@ExperimentalAnimationApi
@ExperimentalMaterialApi
fun NavGraphBuilder.listComposable(
    navigateToTaskScreen: (Int) -> Unit,
    sharedViewModel: SharedViewModel
) {
    composable(
        route = LIST_SCREEN,
        arguments = listOf(navArgument(LIST_ARGUMENT_KEY) {
            type = NavType.StringType
        })
    ) { navBackStackEntry ->
        val action = navBackStackEntry.arguments?.getString(LIST_ARGUMENT_KEY).toAction()

        // Save action across configuration changes (Screen rotation)
        var myAction by rememberSaveable {
            mutableStateOf(Action.NO_ACTION)
        }

        LaunchedEffect(key1 = myAction) {
            if (action != myAction) {
                myAction = action
                sharedViewModel.action.value = action
            }
        }

        val databaseAction by sharedViewModel.action


        ListScreen(
            navigateToTaskScreen = navigateToTaskScreen,
            sharedViewModel = sharedViewModel,
            action = databaseAction
        )
    }
}
