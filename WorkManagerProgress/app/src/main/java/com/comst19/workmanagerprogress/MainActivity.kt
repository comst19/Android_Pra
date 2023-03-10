package com.comst19.workmanagerprogress

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkInfo
import androidx.work.WorkManager
import com.comst19.workmanagerprogress.WorkManagerTest.Companion.HowMuch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val workerManagerTest = OneTimeWorkRequestBuilder<WorkManagerTest>().build()
        WorkManager.getInstance(this).enqueue(workerManagerTest)

        WorkManager.getInstance(this)
            .getWorkInfoByIdLiveData(workerManagerTest.id)
            .observe(this, Observer { workInfo : WorkInfo? ->
                val progress = workInfo?.progress
                val value = progress?.getInt(HowMuch, 0)
                if(value != 0){
                    Log.d("MainActivity", value.toString())
                }
                if(value == 100){
                    Log.d("MainActivity", "이제 끝끝")
                }
            })
    }
}