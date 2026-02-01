package com.sunpra.memories.data

import com.sunpra.memories.model.Memory
import com.sunpra.memories.model.RegistrationBody
import com.sunpra.memories.model.RegistrationResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface MemoriesService {

    @POST("user/register")
    suspend fun registerUser(@Body registrationBody: RegistrationBody):
            Response<RegistrationResponse>

    @GET("api/memory")
    suspend fun getMyMemories(
        @Header("Authorization") authToken: String
    ): Response<List<Memory>>

}