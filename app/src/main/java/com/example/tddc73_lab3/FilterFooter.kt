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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.compositeOver
import androidx.compose.ui.graphics.luminance
import androidx.compose.ui.graphics.toArgb
import androidx.core.graphics.ColorUtils

@Composable
fun FilterFooter(viewModel: RepoViewModel) {
    Color(ColorUtils.blendARGB(MaterialTheme.colorScheme.primary.toArgb(), Color.Black.toArgb(), 0.5f))
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
            if (viewModel.selectedRepo == null) FilterFab(viewModel = viewModel)
        }
    )
}

