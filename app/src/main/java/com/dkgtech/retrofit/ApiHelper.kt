package com.dkgtech.retrofit

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiHelper {


    @GET("quotes")
    fun getQuotes(): Call<DataModel>

    companion object {

        val BASE_URL = "https://dummyjson.com/"

        fun create(): ApiHelper {

            val retrofitClient = Retrofit
                .Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofitClient.create(ApiHelper::class.java)
        }
    }
}