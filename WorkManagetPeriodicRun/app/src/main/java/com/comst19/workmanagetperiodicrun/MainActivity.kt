package com.comst19.workmanagetperiodicrun

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import java.util.concurrent.TimeUnit

// 주기적으로 실행

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val workManager = PeriodicWorkRequestBuilder<WorkManager1>(15,TimeUnit.MINUTES).build()
        WorkManager.getInstance(this).enqueue(workManager)
    }
}