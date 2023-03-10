package com.comst19.viewmodellivedatalifecycleowner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.comst19.viewmodellivedatalifecycleowner.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewMdel : MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewMdel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding.vm = viewMdel
        binding.lifecycleOwner = this

        binding.next.setOnClickListener {
            viewMdel.getNextData()
        }

    }
}