package com.example.tddc73_lab3

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController


val Languages = listOf("all", "python", "javascript", "typescript", "c", "c++", "c#")


class RepoViewModel: ViewModel() {
    var selectedRepo: TrendingRepoQuery.OnRepository?
            by mutableStateOf(null)
    private set

   var navController by mutableStateOf<NavController?>(null)

    var selectedLanguages by mutableStateOf(listOf("all"))
    private set

    fun setRepo(repo: TrendingRepoQuery.OnRepository?) {
        selectedRepo = repo
        if(repo == null){
            navController?.navigate("mainpage")
        }else{
            navController?.navigate("moreInfoPage")
        }
    }

    fun setLanguages(language: String) {
        selectedLanguages.plus(language)
    }

    fun changeNavController(navCon:NavController)  {
        navController = navCon
    }
}