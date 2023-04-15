package com.example.picture

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.picture.ui.theme.PictureTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PictureTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Navigator()
                }
            }
        }
    }

    @Composable
    fun Navigator(
        navController: NavHostController = rememberNavController(),
    ) {
        Surface() {
            NavHost(
                navController = navController,
                startDestination = "home",
            ) {
                composable("home") {
                    User_Input(navController=  navController)
                }
                composable("Show Image/{width}/{height}/{category}",
                    arguments = listOf(
                        navArgument("width"){type = NavType.StringType},
                        navArgument("height"){type = NavType.StringType},
                        navArgument("category"){type = NavType.StringType}
                    )) {backStackEntry ->
                    val width = backStackEntry.arguments?.getString("width")
                    val height = backStackEntry.arguments?.getString("height")
                    val category = backStackEntry.arguments?.getString("category")
                    if (width != null) {
                        if (height != null) {
                            if (category != null) {
                                User_View(navController, width,height,category)
                            }
                        }
                    }
                }
            }
        }
    }
}

