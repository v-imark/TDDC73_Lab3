package com.example.tddc73_lab3

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import java.time.LocalDate
import java.time.format.DateTimeFormatter


val Languages = listOf("all", "python", "javascript", "typescript", "c", "c++", "c#")
val Timeframes = listOf("all time", "this year", "last month", "last week")


class RepoViewModel: ViewModel() {
    var selectedRepo: TrendingRepoQuery.OnRepository?
            by mutableStateOf(null)
    private set

    var navController by mutableStateOf<NavController?>(null)
    private set

    var selectedLanguages by mutableStateOf(listOf("all"))
    private set

    var selectedTimeframe by mutableStateOf("all time")
    private set

    fun setRepo(repo: TrendingRepoQuery.OnRepository?) {
        selectedRepo = repo
        if(repo == null){
            navController?.navigate("mainpage")
        }else{
            navController?.navigate("moreInfoPage")
        }
    }

    fun addLanguages(language: String) {
        selectedLanguages = selectedLanguages.plusElement(language)
    }

    fun removeLanguages(language: String) {
        selectedLanguages = selectedLanguages.minusElement(language)
    }

    fun changeNavController(navCon:NavController)  {
        navController = navCon
    }

    fun setTimeframe(timeframe: String){
        selectedTimeframe = timeframe
    }

    fun getQueryString(): String {
        val today = LocalDate.now()

        val format = DateTimeFormatter.ofPattern("yyyy-MM-dd")

        var query = "created:>"
        when (selectedTimeframe) {
            "all time" -> query = ""
            "last week" -> query += today.minusWeeks(1).format(format)
            "this year" -> query += today.withDayOfYear(1).format(format)
            "last month" -> query += today.minusMonths(1).format(format)
        }

        for (language in selectedLanguages) {
            query += " language:$language"
        }

        return "$query stars:>0"
    }

}