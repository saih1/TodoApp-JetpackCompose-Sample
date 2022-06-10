package com.example.todojetpackcomposemvvm.navigation.destinations

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideOutVertically
import androidx.compose.material.ExperimentalMaterialApi
import androidx.navigation.NavGraphBuilder
import com.example.todojetpackcomposemvvm.ui.screens.splash.SplashScreen
import com.example.todojetpackcomposemvvm.util.Constants
import com.google.accompanist.navigation.animation.composable

@ExperimentalAnimationApi
@ExperimentalMaterialApi
fun NavGraphBuilder.splashComposable(
    navigateToListScreen: () -> Unit,
) {
    composable(
        route = Constants.SPLASH_SCREEN,
        exitTransition = {
            slideOutVertically(animationSpec = tween(300))
        }
    ) {
        SplashScreen(navigateToListScreen = navigateToListScreen)
    }
}