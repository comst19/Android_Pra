package com.comst19.workmanageruniquework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.work.ExistingWorkPolicy
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val testBtn = findViewById<Button>(R.id.testBtn)

        testBtn.setOnClickListener {
            val testWorkManager = OneTimeWorkRequestBuilder<TestWorkManager>().build()

            // 버튼을 누를 때마다 실행
            //WorkManager.getInstance(this).enqueue(testWorkManager)

            // KEEP 먼저 실행 된 WorkManager가 끝날 때까지 실행이 되지 않음, REPLACE 먼저 실행 된 WorkManager을 중지하고 다시 처음부터 실행
            WorkManager.getInstance(this).enqueueUniqueWork("test", ExistingWorkPolicy.KEEP, testWorkManager)

        }
    }
}