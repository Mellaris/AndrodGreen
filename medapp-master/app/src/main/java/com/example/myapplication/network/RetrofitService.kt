package com.example.myapplication.network

import com.example.myapplication.models.UserRequest
import com.example.myapplication.models.UserResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface RetrofitService {

    @POST("user/login")
    suspend fun authorization(@Body userRequest: UserRequest): Response<UserResponse>

}