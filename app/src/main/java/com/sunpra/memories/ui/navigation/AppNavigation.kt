package com.sunpra.memories.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import com.sunpra.memories.ui.screen.HomeScreen
import com.sunpra.memories.ui.screen.RegistrationScreen
import kotlinx.serialization.Serializable

@Serializable
data object Registration

@Serializable
data object Login

@Serializable
data object Home

@Serializable
data class MemoryDetail(val id: String)

@Composable
fun AppNavigation() {
    val backStack = remember { mutableStateListOf<Any>(Registration) }


    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = entryProvider {
            entry<Registration> {
                RegistrationScreen(
                    navigateToHomeScreen = {
                        backStack.clear()
                        backStack.add(Home)
                    }
                )
            }
            entry<Home> {
                HomeScreen()
            }
        }
    )
}