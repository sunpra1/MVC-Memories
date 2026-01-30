package com.sunpra.memories.data

import com.sunpra.memories.model.RegistrationBody
import com.sunpra.memories.model.RegistrationResponse
import retrofit2.Response

class Repository(private val memoryService: MemoriesService) {

    suspend fun registerUser(registrationBody: RegistrationBody): Result<RegistrationResponse> {
        val response: Response<RegistrationResponse> = memoryService.registerUser(registrationBody)
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