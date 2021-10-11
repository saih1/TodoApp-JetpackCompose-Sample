package com.example.todojetpackcomposemvvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.todojetpackcomposemvvm.navigation.SetupNavigation
import com.example.todojetpackcomposemvvm.ui.theme.TodoJetpackComposeMVVMTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TodoJetpackComposeMVVMTheme {
                navController = rememberNavController()
                SetupNavigation(navController = navController)
            }
        }
    }
}
