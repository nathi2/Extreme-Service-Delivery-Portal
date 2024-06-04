package com.example.myexsds


import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
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
// Sign-Up Screen.

@Composable
fun SignUpScreen(navController: NavHostController, onSignUp: (User) -> Unit) {

    var name by remember { mutableStateOf("") }
    var surname by remember { mutableStateOf("") }
    var address by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var gender by remember { mutableStateOf("") }
    var contactDetails by remember { mutableStateOf("") }
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var selectedRole by remember { mutableStateOf(UserRole.COMMUNITY_MEMBER) }
    var showError by remember { mutableStateOf(false) }

    LazyColumn(

        modifier = Modifier

            .fillMaxSize()
            .padding(16.dp),

        horizontalAlignment = Alignment.CenterHorizontally

    ) {

        item {

            Text(text = "Sign Up", style = MaterialTheme.typography.headlineLarge)

            Spacer(modifier = Modifier.height(16.dp))

            TextField(

                value = name,

                onValueChange = { name = it },
                label = { Text("Name") },

                modifier = Modifier.fillMaxWidth()

            )

            Spacer(modifier = Modifier.height(16.dp))

            TextField(

                value = surname,

                onValueChange = { surname = it },
                label = { Text("Surname") },

                modifier = Modifier.fillMaxWidth()

            )

            Spacer(modifier = Modifier.height(16.dp))

            TextField(

                value = address,

                onValueChange = { address = it },
                label = { Text("Address") },

                modifier = Modifier.fillMaxWidth()

            )

            Spacer(modifier = Modifier.height(16.dp))

            TextField(

                value = email,

                onValueChange = { email = it },
                label = { Text("Email") },

                modifier = Modifier.fillMaxWidth()

            )

            Spacer(modifier = Modifier.height(16.dp))

            TextField(

                value = gender,

                onValueChange = { gender = it },
                label = { Text("Gender") },

                modifier = Modifier.fillMaxWidth()

            )

            Spacer(modifier = Modifier.height(16.dp))

            TextField(

                value = contactDetails,

                onValueChange = { contactDetails = it },
                label = { Text("Contact Details") },

                modifier = Modifier.fillMaxWidth()

            )

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

            TextField(

                value = confirmPassword,

                onValueChange = { confirmPassword = it },
                label = { Text("Confirm Password") },

                modifier = Modifier.fillMaxWidth(),

                visualTransformation = PasswordVisualTransformation()

            )

            Spacer(modifier = Modifier.height(16.dp))

            if (showError) {

                Text(text = "Passwords do not match", color = MaterialTheme.colorScheme.error)

                Spacer(modifier = Modifier.height(16.dp))

            }

            Text(text = "Role", style = MaterialTheme.typography.headlineLarge)

            Row(

                //   modifier = Modifier.align(Alignment.CenterHorizontally)

            ) {

                RadioButton(

                    selected = selectedRole == UserRole.COMMUNITY_MEMBER,

                    onClick = { selectedRole = UserRole.COMMUNITY_MEMBER }

                )

                Text(text = "Community Member", modifier = Modifier.padding(start = 8.dp))

                Spacer(modifier = Modifier.width(16.dp))

                RadioButton(

                    selected = selectedRole == UserRole.GOVERNMENT_OFFICIAL,

                    onClick = { selectedRole = UserRole.GOVERNMENT_OFFICIAL }

                )

                Text(text = "Government Official", modifier = Modifier.padding(start = 8.dp))

            }

            Spacer(modifier = Modifier.height(16.dp))


            Button(onClick = {
                navController.navigate("signUp")

                if (password == confirmPassword) {

                    val newUser = User(

                        id = (1..1000).random(),
                        name = name,
                        surname = surname,
                        address = address,
                        email = email,
                        gender = gender,
                        contactDetails = contactDetails,
                        username = username,
                        password = password,
                        role = selectedRole

                    )

                    onSignUp(newUser)

                } else {

                    showError = true

                }

            }

                //   modifier = Modifier.align(Alignment.End)

            ) {

                Text("Sign Up")

            }

        }

    }
}
