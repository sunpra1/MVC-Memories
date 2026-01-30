package com.sunpra.memories.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

//{
// "token":"43|49KJVGJuqHmdgaqMeW7gLWCrTHxO4gACDpb1K6MG9cd16f0f",
// "user":{
//      "name":"Sunil Prasai",
//      "email":"dev.sunpra@gmail.com",
//      "updated_at":"2026-01-29T03:16:27.000000Z",
//      "created_at":"2026-01-29T03:16:27.000000Z",
//      "id":14
//      }
// }

@Serializable
data class RegistrationResponse(
    val token: String,
    val user: User
)

@Serializable
data class User (
    val id: Int,
    val name: String,
    val email: String,
    @SerialName("updated_at")
    val updatedAt: String,
    @SerialName("created_at")
    val createdAt: String
)


