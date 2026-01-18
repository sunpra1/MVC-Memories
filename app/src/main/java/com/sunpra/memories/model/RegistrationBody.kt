package com.sunpra.memories.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RegistrationBody(
    val name: String,
    val email: String,
    val password: String,
    @SerialName("confirm_password")
    val confirmPassword: String
)
