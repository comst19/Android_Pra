package com.comst19.workmanagercoroutine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val workManager = OneTimeWorkRequestBuilder<WorkManager2>().build()
        WorkManager.getInstance(this).enqueue(workManager)
    }
}