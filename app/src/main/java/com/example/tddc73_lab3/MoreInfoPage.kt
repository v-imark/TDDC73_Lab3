package com.example.tddc73_lab3

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable



@Composable
fun MoreInfoPage(viewModel: RepoViewModel) {
    Text(viewModel.selectedRepo?.name ?: " ")
    
    Button(onClick = {viewModel.setRepo(null)} ){

    }

}



