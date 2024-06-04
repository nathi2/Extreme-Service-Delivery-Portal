package com.example.myexsds

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Nav() {

    val navController = rememberNavController()

    val users = remember { mutableStateListOf<User>() }

    val signedInUser = remember { mutableStateOf<User?>(null) }


    NavHost(navController = navController, startDestination = "home"){

        composable("home") {

            HomeScreen(navController)

        }

        composable("signUp") {

            SignUpScreen( navController, onSignUp = { user -> users.add(user)

                navController.navigate("signUp")

            })

        }


        composable("signIn") {

            SignInScreen( navController, users, onSignIn = { user -> signedInUser.value = user

                navController.navigate("signIn")

            })

        }

        composable("IssueReporting") {

            ReportIssueScreen(navController)

        }

    }

}

