package com.example.tddc73_lab3

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.text.style.TextAlign

@Composable
fun MoreInfoPage(viewModel: RepoViewModel) {

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.DarkGray
    ) {
        Column (horizontalAlignment = Alignment.CenterHorizontally,
            ){
           Box(modifier = Modifier
               .background(Color(0xFF212121))
               .fillMaxWidth()
               .padding(vertical = 15.dp),
               )
                {
               Column(modifier = Modifier.fillMaxWidth(),
                   horizontalAlignment = Alignment.CenterHorizontally) {
                   Text(text = viewModel.selectedRepo?.name ?: " ",
                    fontWeight = FontWeight.Bold,
                    fontSize = 6.em,
                    color = Color(0xFFdab3ff),
                    )
                    Text(text = viewModel.selectedRepo?.owner?.login ?: "",
                        modifier = Modifier
                            .padding(top=2.dp, bottom = 15.dp),
                        fontWeight = FontWeight.Bold,
                        fontSize = 3.5.em,
                        color = Color.Gray,
                    )
                   Row {
                       StatBox(icon = R.drawable.star,
                           stat = viewModel.selectedRepo?.stargazerCount ?: 0,
                           color=Color(0xFF212121))
                       StatBox(icon = R.drawable.fork,
                           stat = viewModel.selectedRepo?.forkCount ?: 0,
                           color=Color(0xFF212121))
                   }
               }
           }
            Text(text = viewModel.selectedRepo?.description ?: " ",
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp, top = 10.dp)
                    .heightIn(min = 0.dp, max = 75.dp),
                fontSize = 4.5.em,
                color = Color.White,
                textAlign = TextAlign.Center
            )
            Text(text = "Created at: " + viewModel.selectedRepo?.createdAt ?: "",
                modifier = Modifier
                    .padding(start=16.dp, top=10.dp, bottom=16.dp),
                fontWeight = FontWeight.Bold,
                fontSize = 3.5.em,
                color = Color.Gray,
            )
            Text(text = "License: " + viewModel.selectedRepo?.licenseInfo?.name ?: "",
                modifier = Modifier
                    .padding(start=16.dp, top=2.dp, bottom=16.dp),
                fontWeight = FontWeight.Bold,
                fontSize = 3.5.em,
                color = Color.Gray,
            )
            Text(text = "Languages:",
                color = Color(0xFFdab3ff),
                fontSize = 4.5.em,)
            LazyColumn(){
                viewModel.selectedRepo?.languages?.edges?.let {
                    items(it.map { edge1 -> edge1?.node?.name ?: " " })
                    { language ->
                        Text(text = "-" + language.toString(),
                            color = Color.Gray)
                    }
                }
            }
            Button(onClick = {viewModel.setRepo(null)} ){
            }
        }
    }
}



