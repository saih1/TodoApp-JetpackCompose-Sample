package com.example.todojetpackcomposemvvm.ui.screens.splash

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.todojetpackcomposemvvm.R
import com.example.todojetpackcomposemvvm.ui.theme.LOGO_HEIGHT
import com.example.todojetpackcomposemvvm.ui.theme.TodoJetpackComposeMVVMTheme
import com.example.todojetpackcomposemvvm.ui.theme.splashScreenBackground
import com.example.todojetpackcomposemvvm.util.Constants.SPLASH_DELAY
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navigateToListScreen: () -> Unit
) {
    var startAnimation by remember {
        mutableStateOf(false)
    }
    
    val offSetState by animateDpAsState(
        targetValue = if (startAnimation) 0.dp else 100.dp,
        animationSpec = tween(
            durationMillis = 1000
        )
    )
    val alphaState by animateFloatAsState(
        targetValue = if (startAnimation) 1f else 0f,
        animationSpec = tween(
            durationMillis = 1000
        )
    )
    
    LaunchedEffect(key1 = true) {
        startAnimation = true
        delay(SPLASH_DELAY)
        navigateToListScreen()
    }
    
    Splash(offSetState = offSetState, alphaState = alphaState)
}

@Composable
fun Splash(
    offSetState: Dp,
    alphaState: Float
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.splashScreenBackground),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier
                .size(LOGO_HEIGHT)
                .offset(y = offSetState)
                .alpha(alpha = alphaState),
            painter = painterResource(
                id = R.drawable.splash_android),
            contentDescription = stringResource(
                id = R.string.splash_icon)
        )
    }
}

@Preview
@Composable
fun SplashScreenPreview() {
    Splash(offSetState = 0.dp, alphaState = 1f)
}