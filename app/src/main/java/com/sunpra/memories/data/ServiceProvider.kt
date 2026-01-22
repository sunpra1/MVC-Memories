package com.sunpra.memories.data

import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlin.time.Duration.Companion.seconds


object ServiceProvider {


    val client = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor())
        .readTimeout(20.seconds)
        .writeTimeout(20.seconds)
        .build()

    val retrofit: Retrofit = Retrofit.Builder()
        .client(client)
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl("https://sunilprasai.com.np/api/")
        .build()

    val memoriesService = retrofit.create(MemoriesService::class.java)

}