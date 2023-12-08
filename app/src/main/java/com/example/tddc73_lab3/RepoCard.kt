package com.example.tddc73_lab3

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun RepoCard(name: String) {
    Text(name)
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
