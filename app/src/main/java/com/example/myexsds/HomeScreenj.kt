package com.example.myexsds

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController


@Composable
fun HomeScreen(navController: NavHostController) {

    Column(

        modifier = Modifier

            .fillMaxSize()
            .padding(16.dp),

        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {

        Text(

            text = "Extreme Service Delivery Portal",

            fontSize = 25.sp,
            modifier = Modifier.padding(bottom = 24.dp)


        )

        Text(

            text = " Empowering communities, One Report at a Time",

            fontSize = 15.sp, // Adjust font size as needed

            fontWeight = FontWeight.SemiBold,
            color = Color.Gray,

            modifier = Modifier.padding(bottom = 24.dp) // Adjust padding as needed

        )

        Button(

            onClick = { navController.navigate("signIn") },

            modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)

        ) {

            Text(text = "Sign In")

        }

        Button(

            onClick = { navController.navigate("signup") },

            modifier = Modifier.fillMaxWidth()

        ) {

            Text(text = "Sign Up")

        }

    }

}






