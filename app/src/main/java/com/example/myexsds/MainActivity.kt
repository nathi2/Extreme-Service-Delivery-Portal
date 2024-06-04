
package com.example.myexsds

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.myexsds.ui.theme.MyExSDsTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            MyExSDsTheme {

                Nav()

            }
        }
    }
}

// Defining the Data Model...

data class User(

    val id: Int,
    val name: String,
    val surname: String,
    val address: String,
    val email: String,
    val gender: String,
    val contactDetails: String,
    val username: String,
    val password: String,
    val role: UserRole

)


enum class UserRole {

    COMMUNITY_MEMBER,
    GOVERNMENT_OFFICIAL

}