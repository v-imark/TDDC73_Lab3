package com.example.tddc73_lab3
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
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
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import com.apollographql.apollo3.exception.ApolloException
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider

@Composable
fun RepoCard(repo: TrendingRepoQuery.OnRepository?, viewModel: RepoViewModel) {
    //val configuration = LocalConfiguration.current
   // val screenHeight = configuration.screenHeightDp.dp
    Card(
        colors = CardDefaults.cardColors(
        containerColor = Color.DarkGray,
    ),
        modifier = Modifier
            .fillMaxWidth()
            .clickable { viewModel.setRepo(repo) }
    )
    {
        Column {
        Text(text = repo?.name ?: " ",
            modifier = Modifier
                .padding(start =16.dp, end= 16.dp, top=16.dp),
            fontWeight = FontWeight.Bold,
            fontSize = 6.em,
            color = Color(0xFFdab3ff),
            )
        Text(text = repo?.owner?.login ?: "",
            modifier = Modifier
                .padding(start=16.dp, top=2.dp, bottom=16.dp),
            fontWeight = FontWeight.Bold,
            fontSize = 3.5.em,
            color = Color.White,
        )
        Text(text = repo?.description ?: "Description was not found.",
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp)
                .heightIn(min = 0.dp, max = 75.dp),
            fontSize = 4.5.em,
            color = Color.White,
        )
        Row (modifier = Modifier.height(IntrinsicSize.Min).fillMaxWidth().padding(top = 15.dp),
            horizontalArrangement = Arrangement.End,)
            {
                //Display forks
                Divider(color = Color(0xFF212121), modifier = Modifier.fillMaxHeight().width(1.dp))
                StatBox(icon = R.drawable.fork, stat = repo?.forkCount ?: 0)
                //Display stars
                Divider(color = Color(0xFF212121), modifier = Modifier.fillMaxHeight().width(1.dp))

                StatBox(icon = R.drawable.star, stat = repo?.stargazerCount ?: 0)

            }
        }
    }
}
@Composable
fun RepoCardList(viewModel: RepoViewModel) {
    var repos
        by remember { mutableStateOf<List<TrendingRepoQuery.OnRepository?>?>(null) }

    LaunchedEffect(viewModel.selectedLanguages, viewModel.selectedTimeframe) {
        try {
            val response = apolloClient
                .query(TrendingRepoQuery(viewModel.getQueryString()))
                .execute()

            println(viewModel.getQueryString())

            if (response.hasErrors()) {
                // Handle errors if needed
            } else {
                repos = response.data?.search?.edges?.map { edge ->
                    edge?.node?.onRepository
                }
            }
        } catch (e: ApolloException) {
            // Handle ApolloException if needed
        }
    }
    if (repos == null) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    } else {
        LazyColumn(
        verticalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier.padding(10.dp)
        ) {
            items(repos ?: emptyList()) { repo ->
                RepoCard(repo = repo, viewModel)
            }
        }
    }
}





