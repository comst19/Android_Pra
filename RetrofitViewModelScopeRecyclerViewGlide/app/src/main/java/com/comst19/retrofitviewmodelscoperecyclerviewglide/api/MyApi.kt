package com.comst19.retrofitviewmodelscoperecyclerviewglide.api

import com.comst19.retrofitviewmodelscoperecyclerviewglide.model.Plant
import retrofit2.http.GET

interface MyApi {
    @GET("googlecodelabs/kotlin-coroutines/master/advanced-coroutines-codelab/sunflower/src/main/assets/plants.json")
    suspend fun getAllPlants() : List<Plant>
}