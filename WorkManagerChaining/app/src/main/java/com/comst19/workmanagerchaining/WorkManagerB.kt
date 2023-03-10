package com.comst19.workmanagerchaining

import android.content.Context
import android.os.SystemClock
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class WorkManagerB(context: Context, workerParameters: WorkerParameters) : Worker(context, workerParameters) {
    override fun doWork(): Result {

        for(i in 0..3){
            SystemClock.sleep(1000)
            Log.d("WorkManagerA",i.toString())
        }

        return Result.success()
    }
}