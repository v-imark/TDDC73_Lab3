package com.example.tddc73_lab3

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun FilterFooter(viewModel: RepoViewModel) {
    BottomAppBar(
        containerColor = MaterialTheme.colorScheme.primaryContainer,
        contentColor = MaterialTheme.colorScheme.primary,
        actions = {
            if (viewModel.selectedRepo != null) {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        Icons.Default.ArrowBack,
                        contentDescription = "Back-button",
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
        },
        floatingActionButton = {
            FilterFab(viewModel = viewModel)
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilterFab(viewModel: RepoViewModel) {
    var expanded by remember { mutableStateOf(false) }
    ExposedDropdownMenuBox(expanded = expanded, onExpandedChange = {}) {
        FloatingActionButton(
            modifier = Modifier.menuAnchor(),
            onClick = { expanded = !expanded },
            containerColor = MaterialTheme.colorScheme.primary,
            elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation()
        ) {
            Icon(
                Icons.Filled.Edit,
                contentDescription = "Fab",
                //modifier = Modifier.fillMaxSize()
            )
        }
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .height(400.dp)
                .width(150.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Divider(modifier = Modifier.fillMaxWidth())
            Languages.forEach { language ->
                DropdownMenuItem(
                    text = { Text(language.uppercase()) },
                    trailingIcon = {
                        if(viewModel.selectedLanguages.contains(language) ) {
                            Icon(Icons.Filled.Check, contentDescription = "check")
                        }
                    },
                    onClick = {
                        if(viewModel.selectedLanguages.contains(language) ) {
                            viewModel.removeLanguages(language)
                        } else {
                            viewModel.addLanguages(language)
                        }
                    }
                )
                Divider(modifier = Modifier.fillMaxWidth())
            }
        }
    }
}