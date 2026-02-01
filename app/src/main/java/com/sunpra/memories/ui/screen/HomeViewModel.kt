package com.sunpra.memories.ui.screen

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import com.sunpra.memories.model.Memory
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class HomeViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUIState())
    val uiState = _uiState.asStateFlow()

    private fun getMyMemories() {
        // TODO use repository to display list of memories
    }

}

data class HomeUIState(
    val memories: SnapshotStateList<Memory> = mutableStateListOf()
)