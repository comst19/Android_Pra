package com.comst19.retrofitviewmodelscoperecyclerviewglide.repository

import com.comst19.retrofitviewmodelscoperecyclerviewglide.api.MyApi
import com.comst19.retrofitviewmodelscoperecyclerviewglide.api.RetrofitInstance

class Repository {
    private val client = RetrofitInstance.getInstance().create(MyApi::class.java)

    suspend fun getAllData() = client.getAllPlants()
}