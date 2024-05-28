package com.waltonbd.randomapi.presentation.landing_screen

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController


/**
 * Created by Ahsan Habib on 5/28/2024.
 */
@Composable
fun LandingScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    val context = LocalContext.current
    Scaffold(
        modifier = modifier
    ) {innerPadding ->
        Column(
            modifier = Modifier.fillMaxSize()
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Button(onClick = { navController.navigate("categories_screen") }) {
                Text(text = "Categories")
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = {
                Toast.makeText(context, "No Product in Cart.", Toast.LENGTH_LONG).show()
            }) {
                Text(text = "Cart")
            }

        }

    }

}