package com.example.myexsds

sealed class Screens( val route : String ) {

    object Home : Screens( route = "Home_Screen")

    object SignInUp : Screens( route = "LogInUp_Screen/{id}")

    object Report : Screens( route = "IssueReporting_Screen/{id}")

}