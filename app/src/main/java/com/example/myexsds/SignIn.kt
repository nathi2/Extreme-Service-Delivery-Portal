package com.example.myexsds


import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

// Creating Functions for Sign-Up and Sign-In.

@Composable
fun SignInScreen(navController: NavHostController, users: List<User>, onSignIn: (User?) -> Unit) {

    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var showError by remember { mutableStateOf(false) }

    LazyColumn(

        modifier = Modifier

            .fillMaxSize()
            .padding(16.dp),

        horizontalAlignment = Alignment.CenterHorizontally

    ) {

        item {

            Text(text = "Sign In", style = MaterialTheme.typography.headlineLarge)

            Spacer(modifier = Modifier.height(16.dp))

            TextField(

                value = username,

                onValueChange = { username = it },
                label = { Text("Username") },

                modifier = Modifier.fillMaxWidth()

            )

            Spacer(modifier = Modifier.height(16.dp))

            TextField(

                value = password,

                onValueChange = { password = it },
                label = { Text("Password") },

                modifier = Modifier.fillMaxWidth(),

                visualTransformation = PasswordVisualTransformation()

            )

            Spacer(modifier = Modifier.height(16.dp))


            if (showError) {

                Text(text = "Invalid username or password", color = MaterialTheme.colorScheme.error)

                Spacer(modifier = Modifier.height(16.dp))

            }

            Button(

                onClick = {  navController.navigate("signIn")

                    val user = users.find { it.username == username && it.password == password }

                    if (user != null) {

                        onSignIn(user)

                    } else {

                        showError = true

                    }

                },

                // modifier = Modifier.align(Alignment.End)

            ) {

                Text("Sign In")

            }

        }

    }

}


