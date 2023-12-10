package com.example.tddc73_lab3

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TimeSelector(viewModel: RepoViewModel) {
    var expanded by remember { mutableStateOf(false) }
    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = it },
        modifier = Modifier.padding(5.dp, 5.dp)
    ) {
        OutlinedTextField(
            value = viewModel.selectedTimeframe.uppercase(),
            onValueChange = {  },
            label = { Text("Timeframe") },
            modifier = Modifier
                .menuAnchor()
                .padding(bottom = 10.dp),
            readOnly = true,
            trailingIcon = {ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)}
        )
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
        ) {
            Divider(modifier = Modifier.fillMaxWidth())
            Timeframes.forEach { timeframe ->
                DropdownMenuItem(
                    text = { Text(timeframe.uppercase()) },
                    trailingIcon = {
                        if(viewModel.selectedTimeframe == timeframe ) {
                            Icon(Icons.Filled.Check, contentDescription = "check")
                        }
                    },
                    onClick = {
                        viewModel.setTimeframe(timeframe)
                    }
                )
                Divider(modifier = Modifier.fillMaxWidth())
            }
        }
    }
}