package com.comst19.coco.network

import com.comst19.coco.network.model.CurrentPriceList
import com.comst19.coco.network.model.RecentCoinPriceList
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

object RetrofitInstance {

    private const val BASE_URL = "https://api.bithumb.com/"

    private val client = Retrofit
        .Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getInstance() : Retrofit {
        return client
    }

}