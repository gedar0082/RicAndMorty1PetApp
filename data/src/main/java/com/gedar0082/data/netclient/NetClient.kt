package com.gedar0082.data.netclient

import android.util.Log
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object NetClient {

    private const val BASE_URL = "https://rickandmortyapi.com/api/"

    val net : ApiService = getBuilder().create(ApiService::class.java)

    private fun getBuilder(): Retrofit = Retrofit.Builder()
        .client(buildClient())
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

//    private fun buildClient() = OkHttpClient.Builder()
//        .connectTimeout(90, TimeUnit.SECONDS)
//        .readTimeout(90, TimeUnit.SECONDS)
//        .build()

    private fun buildClient() : OkHttpClient{
        Log.e("asdas", "asdasd")
        return OkHttpClient.Builder()
            .connectTimeout(90, TimeUnit.SECONDS)
            .readTimeout(90, TimeUnit.SECONDS)
            .build()
    }

}