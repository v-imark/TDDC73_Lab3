package com.example.tddc73_lab3

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun FilterFooter(viewModel: RepoViewModel) {
    BottomAppBar(
        containerColor = MaterialTheme.colorScheme.primaryContainer,
        contentColor = MaterialTheme.colorScheme.primary,
        actions = {
            if (viewModel.selectedRepo != null) {
                IconButton(onClick = { viewModel.setRepo(null) }) {
                    Icon(
                        Icons.Default.ArrowBack,
                        contentDescription = "Back-button",
                        modifier = Modifier.fillMaxSize()
                    )
                }
            } else {
                TimeSelector(viewModel = viewModel)
            }
        },
        floatingActionButton = {
            FilterFab(viewModel = viewModel)
        }
    )
}

