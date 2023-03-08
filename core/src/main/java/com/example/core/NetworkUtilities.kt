package com.example.core

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

fun getRetrofitClient(
    baseUrl: String,
    okHttpClient: OkHttpClient = getOkHttpClient(),
    convertorFactory: Converter.Factory = GsonConverterFactory.create()
): Retrofit {
    return Retrofit.Builder()
        .client(okHttpClient)
        .addConverterFactory(convertorFactory)
        .baseUrl(baseUrl)
        .build()
}

fun getOkHttpClient(interceptors: List<Interceptor> = listOf()): OkHttpClient {
    val okHttpClientBuilder = OkHttpClient.Builder()
    interceptors.forEach {
        okHttpClientBuilder.addInterceptor(it)
    }
    return okHttpClientBuilder.build()
}