package com.example.tddc73_lab3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tddc73_lab3.ui.theme.TDDC73_Lab3Theme

class MainActivity : ComponentActivity() {
    val viewModel = RepoViewModel()
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TDDC73_Lab3Theme {
                val navController = rememberNavController()
                viewModel.changeNavController(navController)
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    //color = MaterialTheme.colorScheme.background
                    bottomBar = { FilterFooter(viewModel = viewModel) }
                ) { innerPadding ->
                    Surface(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        NavHost(navController = navController, startDestination = "mainpage") {
                            composable("mainpage")
                            { MainPage ( viewModel) }
                            composable("moreInfoPage")
                            { MoreInfoPage(viewModel) }
                        }
                    }
                }
            }
        }
    }
}