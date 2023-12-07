import com.apollographql.apollo3.ApolloClient

val apolloClient = ApolloClient.Builder()
    .serverUrl("https://api.github.com/graphql")
    .addHttpHeader("Authorization", "Bearer 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")
    .build()