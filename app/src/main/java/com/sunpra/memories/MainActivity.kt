package com.sunpra.memories

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.lifecycleScope
import com.sunpra.memories.data.ServiceProvider
import com.sunpra.memories.model.RegistrationBody
import com.sunpra.memories.ui.screen.HomeScreen
import com.sunpra.memories.ui.screen.RegistrationScreen
import com.sunpra.memories.ui.theme.MemoriesTheme
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json
import kotlinx.serialization.serializer

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MemoriesTheme {
                RegistrationScreen()
            }
        }
    }
}