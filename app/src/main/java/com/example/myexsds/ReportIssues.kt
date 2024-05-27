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
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.launch

data class Technician(val id: Int, val name: String)

@Composable
fun ReportIssueScreen() {

    var description by remember { mutableStateOf(TextFieldValue()) }
    var message by remember { mutableStateOf("") }
    var assignedTechnician by remember { mutableStateOf<Technician?>(null) }

    val technicians = listOf(

        Technician(1, "Technician A"),
        Technician(2, "Technician B"),
        Technician(3, "Technician C"),
        Technician(4, "Technician D")

    )

    val scope = rememberCoroutineScope()

    Column(

        modifier = Modifier

            .fillMaxSize()
            .padding(16.dp),

        verticalArrangement = Arrangement.Center

    ) {

        Text(text = "Report an Issue", style = MaterialTheme.typography.headlineLarge)

        Spacer(modifier = Modifier.height(16.dp))

        TextField(

            value = description,

            onValueChange = { description = it },

            label = { Text("Description") },

            modifier = Modifier

                .fillMaxWidth()
                .height(150.dp)

        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(

            onClick = {

                scope.launch {

                    assignedTechnician = technicians.random()
                    message = "Issue reported successfully and assigned to ${assignedTechnician?.name}"

                }

            },

            modifier = Modifier.align(Alignment.End)

        ) {

            Text("Submit")

        }

        Spacer(modifier = Modifier.height(16.dp))

        if (message.isNotEmpty()) {

            Text(

                text = message,

                color = MaterialTheme.colorScheme.primary

            )

        }

    }

}


@Preview(showBackground = true)
@Composable
fun ReportIssueScreenPreview() {

    IssueSystemTheme {

        ReportIssueScreen()

    }

}

@Composable
fun IssueSystemTheme(content: @Composable () -> Unit) {

    MaterialTheme {

        Surface(color = MaterialTheme.colorScheme.background) {

            content()

        }

    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {

    IssueSystemTheme {

        ReportIssueScreen()

    }

}

