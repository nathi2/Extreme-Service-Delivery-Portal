package com.example.myexsds

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController


// Create the Home Screen

@Composable
fun HomeScreen() {

    var currentUser by remember { mutableStateOf<User?>(null) }
    var showSignUp by remember { mutableStateOf(false) }
    var showSignIn by remember { mutableStateOf(false) }

    val users = remember { mutableStateListOf<User>() }

    if (currentUser != null) {

       // Text(text = "Welcome, ${currentUser!!.username} (${currentUser!!.role})")

    } else {

        Column(

            modifier = Modifier

                .fillMaxSize()
                .padding(16.dp),

            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {

            Text(text = "Welcome to the Extreme Service Delivery Portal", style = MaterialTheme.typography.headlineLarge)


            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = { showSignIn = true }) {

                Text("Sign In")

            }

            Spacer(modifier = Modifier.height(8.dp))

            Button(onClick = { showSignUp = true }) {

                Text("Sign Up")

            }

            if (showSignUp) {

                SignUpScreen(onSignUp = { user ->

                    users.add(user)
                    currentUser = user

                    showSignUp = false

                })

            }

            if (showSignIn) {

                SignInScreen(users = users, onSignIn = { user ->

                    if (user != null) {

                        currentUser = user

                        showSignIn = false

                    }

                })

            }

        }

    }

}


@Preview(showBackground = true)

@Composable
fun HomeScreenPreview() {

    UIHomeScreenTheme {

        HomeScreen()

    }

}




// Set Up the Theme (Optional)

@Composable
fun UIHomeScreenTheme(content: @Composable () -> Unit) {

    UIHomeScreenTheme {

        Surface(color = MaterialTheme.colorScheme.background) {

            content()

        }

    }

}




