package com.comst19.viewmodelinactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
//    private var countValue = 0

    lateinit var viewModel : MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val plusBtn : Button = findViewById(R.id.plus)
        val minusBtn : Button = findViewById(R.id.minus)
        val resultArea : TextView = findViewById(R.id.result)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        resultArea.text = viewModel.countValue.toString()

        plusBtn.setOnClickListener {
            viewModel.plus()
            resultArea.text = viewModel.countValue.toString()
//            countValue++
//            resultArea.text = countValue.toString()

        }
        minusBtn.setOnClickListener {
            viewModel.minus()
            resultArea.text = viewModel.countValue.toString()
//            countValue--
//            resultArea.text = countValue.toString()
        }

    }
}