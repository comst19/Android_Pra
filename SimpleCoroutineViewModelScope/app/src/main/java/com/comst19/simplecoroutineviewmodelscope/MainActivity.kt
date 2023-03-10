package com.comst19.simplecoroutineviewmodelscope

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        Log.d("Test", "START")
//        CoroutineScope(Dispatchers.IO).launch {
//            Log.d("Test","CoroutineScope START")
//            a()
//            b()
//            Log.d("Test","CoroutineScope END")
//        }
//        Log.d("Test","END")

        // START -> END -> AP1 -> BP1 -> AP2 -> BP2

        val goToSecond = findViewById<Button>(R.id.goToSecond)
        goToSecond.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

    }

    suspend fun a(){
        delay(1000)
        Log.d("Test", "AP1")
        delay(1000)
        Log.d("Test", "AP2")
    }
    suspend fun b(){
        delay(1000)
        Log.d("Test", "BP1")
        delay(1000)
        Log.d("Test", "BP2")
    }
}