package com.comst19.databindingdataclass

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import com.comst19.databindingdataclass.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    var testCount = 20

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // 기존의 방법
        //binding.test.text = "바뀐 텍스트"

        // 데이터 결합
        val person = Person("comst",25)
        binding.user = person

    }

    fun myClick(view : View){
        Log.d("MainActivity", "onclick")
        testCount++
        val person = Person("comst",testCount)
        binding.user = person

    }
}