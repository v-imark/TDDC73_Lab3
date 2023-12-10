package com.example.tddc73_lab3

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun MainPage( viewModel:RepoViewModel) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFF212121)
    ) {
        RepoCardList(viewModel)
    }

}