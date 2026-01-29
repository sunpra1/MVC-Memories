package com.sunpra.memories.data

import com.sunpra.memories.model.RegistrationBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface MemoriesService {

    @POST("user/register")
    suspend fun registerUser(@Body registrationBody: RegistrationBody): Response<String>

}