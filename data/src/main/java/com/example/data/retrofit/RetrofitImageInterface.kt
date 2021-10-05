package com.example.data.retrofit

import com.example.domain.dto.CardDto
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitImageInterface {

    @GET(value = "id.png")
    fun allImageCard(): Call<MutableList<CardDto>>
}