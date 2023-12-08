package com.example.tddc73_lab3

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel



val Languages = listOf("all", "python", "javascript", "typescript", "c", "c++", "c#")



class RepoViewModel: ViewModel() {
    var selectedRepo: TrendingRepoQuery.OnRepository?
            by mutableStateOf(null)
    private set

    var selectedLanguages by mutableStateOf(listOf("all"))
    private set

    fun setRepo(repo: TrendingRepoQuery.OnRepository?) {
        selectedRepo = repo
    }

    fun setLanguages(language: String) {
        selectedLanguages.plus(language)
    }
}