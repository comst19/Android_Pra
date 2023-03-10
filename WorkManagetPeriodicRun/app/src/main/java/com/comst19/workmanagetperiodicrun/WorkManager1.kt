package com.comst19.workmanagetperiodicrun

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import java.text.SimpleDateFormat
import java.util.*

class WorkManager1(context: Context, workerParameters: WorkerParameters) :
    Worker(context,workerParameters) {
    override fun doWork(): Result {

        Log.d("WorkManager1","doWork")

        val format = SimpleDateFormat("hh:mm:ss")
        val currentTime = format.format(Date())

        Log.d("WorkManager1", currentTime)
        return Result.success()
    }
}