package com.comst19.workmanagercoroutine

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class WorkManager2(context: Context, params : WorkerParameters) : CoroutineWorker(context, params) {
    override suspend fun doWork(): Result {

        withContext(Dispatchers.IO){
            test1()
            test2()
        }

        return Result.success()
    }

    suspend fun test1(){
        for(i in 1..3){
            delay(1000)
            Log.d("WorkManager2 - test1", i.toString())
        }
    }

    suspend fun test2(){
        for(i in 1..3){
            delay(1000)
            Log.d("WorkManager2 - test2", i.toString())
        }
    }
}