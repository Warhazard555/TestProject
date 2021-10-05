package com.example.data.retrofit

import com.example.data.BASE_URL
import com.example.data.URL_JPG
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {

    private val loggingInterceptor = HttpLoggingInterceptor()

    init {
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
    }

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()

    private val retrofitBuilder = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .build()

    private val retrofitImageBuilder = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(URL_JPG)
        .client(okHttpClient)
        .build()

    fun getImageRetrofit(): RetrofitImageInterface = retrofitImageBuilder.create(RetrofitImageInterface::class.java)

    fun getRetrofit(): RetrofitInterface = retrofitBuilder.create(RetrofitInterface::class.java)
}