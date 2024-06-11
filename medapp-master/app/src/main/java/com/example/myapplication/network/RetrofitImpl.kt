package com.example.myapplication.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitImpl {
    val url = "http://mskko2021.mad.hakta.pro/api/"
   val retrofit = Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    fun create(): RetrofitService =  retrofit.create(RetrofitService::class.java)
}