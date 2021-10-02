package com.example.data.retrofit

import com.example.domain.dto.CardDto
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitInterface {


    @GET(value = "93849/ruRU/cards.json")
    fun allCards(): Call<MutableList<CardDto>>
}