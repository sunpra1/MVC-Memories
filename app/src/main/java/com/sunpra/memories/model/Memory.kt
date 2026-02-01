package com.sunpra.memories.model

import kotlinx.serialization.Serializable

@Serializable
data class Memory(
    val id: Int,
    val image: String,
    val title: String,
    val description: String
)
