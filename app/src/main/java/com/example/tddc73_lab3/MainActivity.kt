package com.example.tddc73_lab3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tddc73_lab3.ui.theme.TDDC73_Lab3Theme

class MainActivity : ComponentActivity() {
    val viewModel = RepoViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TDDC73_Lab3Theme {
                val navController = rememberNavController()
                viewModel.changeNavController(navController)
                NavHost(navController = navController, startDestination = "mainpage") {
                    composable("mainpage")
                    { MainPage ( viewModel) }
                    composable("moreInfoPage")
                    { MoreInfoPage(viewModel) }
                }
                // A surface container using the 'background' color from the theme

            }
        }
    }
}