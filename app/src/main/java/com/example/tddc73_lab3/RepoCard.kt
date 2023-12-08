package com.example.tddc73_lab3

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import apolloClient

@Composable
fun RepoCard(name: String) {
    //val configuration = LocalConfiguration.current
   // val screenHeight = configuration.screenHeightDp.dp
    Card(colors = CardDefaults.cardColors(
        containerColor = MaterialTheme.colorScheme.surfaceVariant,
    ),
        modifier = Modifier
            .fillMaxWidth()
            //.height(screenHeight / 5)
            .padding(10.dp)
    )
    {
        Column {
        Text(text = name,
            modifier = Modifier
                .padding(start =16.dp, end= 16.dp, top=16.dp),
            fontWeight = FontWeight.Bold,
            fontSize = 6.em,
            )
        Text(text = "Name of the author",
            modifier = Modifier
                .padding(start=16.dp, top=2.dp, bottom=16.dp),
            fontWeight = FontWeight.Bold,
            fontSize = 3.5.em,
        )
        Text(text = "This is the text that describes the repo, very informative. " +
                "It contains all the relevant info. The content should probably be wrapped soon. " +
                "This entire sentence will not be seen.",
            modifier = Modifier
                .padding(start=16.dp, end=16.dp)
                .heightIn(min=0.dp, max=75.dp),
            fontSize = 4.5.em,
        )
        Row (modifier = Modifier.fillMaxWidth().padding(top = 10.dp),
            horizontalArrangement = Arrangement.End,)
            {
                //Display forks
                StatBox(icon = R.drawable.fork, stat = 6000)
                //Display stars
                StatBox(icon = R.drawable.star, stat = 3000, Color.Gray)
            }
        }
    }
}


@Composable
fun StatBox(icon:Int, stat:Int=0, color: Color= Color.DarkGray) {
    Box(
        modifier = Modifier
            .background(color = color)
            .width(80.dp)
            .height(30.dp),
        contentAlignment = Alignment.Center,
    ){
        Row (horizontalArrangement = Arrangement.SpaceEvenly){
            Image(painter = painterResource(id = icon),
                contentDescription = "star image",
                modifier = Modifier.size(20.dp))
            Text(text = stat.toString(), color = Color.White)
        }
    }
}

@Composable
fun RepoCardList() {
    var name by remember { mutableStateOf("") }

    LaunchedEffect(true) {
        val response
        = apolloClient.query(TrendingRepoQuery("language:python stars:>1000")).execute()

        name = response.data?.search?.edges?.get(0)?.node?.onRepository?.name ?: ""
    }

    RepoCard(name = name)
}
