package com.sunpra.memories

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.sunpra.memories.model.RegistrationBody
import com.sunpra.memories.ui.screen.HomeScreen
import com.sunpra.memories.ui.theme.MemoriesTheme
import kotlinx.serialization.json.Json

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val registrationBody = RegistrationBody(
            name = "Sunil Prasai",
            email = "sunpra12@gmail.com",
            password = "123123",
            confirmPassword = "123123"
        )

        val json = Json.encodeToString(registrationBody)

        println(json)

        setContent {
            MemoriesTheme {
                HomeScreen()
            }
        }
    }
}