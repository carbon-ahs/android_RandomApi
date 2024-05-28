package com.waltonbd.randomapi.presentation.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.waltonbd.randomapi.presentation.categories_screen.CategoriesScreen
import com.waltonbd.randomapi.presentation.landing_screen.LandingScreen
import com.waltonbd.randomapi.presentation.products_screen.ProductsScreen
import com.waltonbd.randomapi.presentation.ui.theme.RandomApiTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RandomApiTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "categories_screen") {
                    composable(
                        route = "landing_screen"
                    ) {
                        LandingScreen(
                            navController = navController,
                        )
                    }
                    composable(
                        route = "categories_screen"
                    ) {
                        CategoriesScreen(
                            navController = navController,
                        )
                    }
                    composable(
                        route = "products_screen/{categoryName}",

                    ) {
                        val categoryName = it.arguments?.getString("categoryName") ?: null

                        // Check if arguments are not null and render the screen
                        if (categoryName!= null ) {
                            ProductsScreen(navController = navController, categoryName = categoryName)
                        }
                    }
                }
                // CharacterScreen()
            }
        }
    }
}

