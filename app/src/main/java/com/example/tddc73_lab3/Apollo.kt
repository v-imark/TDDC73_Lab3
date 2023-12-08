package com.example.tddc73_lab3

import com.apollographql.apollo3.ApolloClient

val apolloClient = ApolloClient.Builder()
    .serverUrl("https://api.github.com/graphql")
    .addHttpHeader("Authorization", BuildConfig.GITHUB_TOKEN)
    .build()