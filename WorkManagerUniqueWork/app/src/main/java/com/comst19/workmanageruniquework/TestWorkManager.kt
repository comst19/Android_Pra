package com.comst19.workmanageruniquework

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters

class TestWorkManager(context: Context, params : WorkerParameters) : CoroutineWorker(context, params) {
    override suspend fun doWork(): Result {
        Log.d("TestWorkManager", "START")

        for(i in 0..3){
            Log.d("TestWorkManager",i.toString())
        }

        Log.d("TestWorkManager","END")

        return Result.success()
    }
}