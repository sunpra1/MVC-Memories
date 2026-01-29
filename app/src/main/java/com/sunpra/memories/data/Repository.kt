package com.sunpra.memories.data

import com.sunpra.memories.model.RegistrationBody
import retrofit2.Response

class Repository(private val memoryService: MemoriesService) {

    suspend fun registerUser(registrationBody: RegistrationBody): Result<String> {
        val response : Response<String> = memoryService.registerUser(registrationBody)
        val responseBody = response.body()
        if(response.isSuccessful && responseBody != null){
            return Result.success(responseBody)
        }else{
            return Result.failure(
                Exception(
                    response.errorBody()?.string() ?: "Registration failed"
                )
            )
        }
    }

}