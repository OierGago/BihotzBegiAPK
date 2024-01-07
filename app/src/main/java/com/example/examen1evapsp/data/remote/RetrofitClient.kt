package com.example.examen1evapsp.data.remote

import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitClient {

    const val API_URI = "http://192.168.0.18:8080/api/"
    //const val API_URI = "http://10.5.7.159:8081/api/"
    //const val API_URI = "http://10.5.7.162:8080/api/"
    //const val API_URI = "http://10.5.7.129:8080/api/"



    val retrofitClient: Retrofit.Builder by lazy {
        Log.e("pueba ", "hay conecxion")
        Retrofit.Builder()
            .baseUrl(API_URI)
            .addConverterFactory(GsonConverterFactory.create())
    }

    val apiInterface: APIInterface by lazy {
        retrofitClient
            .build()
            .create(APIInterface::class.java)
    }

}