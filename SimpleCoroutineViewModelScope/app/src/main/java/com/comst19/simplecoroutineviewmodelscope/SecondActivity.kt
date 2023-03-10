package com.comst19.simplecoroutineviewmodelscope

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider

// https://developer.android.com/topic/libraries/architecture/coroutines?hl=ko

class SecondActivity : AppCompatActivity() {

    lateinit var viewModel: SecondViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        viewModel = ViewModelProvider(this).get(SecondViewModel::class.java)
        viewModel.a()
        viewModel.b()
    }
}