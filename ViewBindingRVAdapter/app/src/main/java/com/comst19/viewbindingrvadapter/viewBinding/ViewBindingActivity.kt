//package com.comst19.viewbindingrvadapter.viewBinding
//
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import androidx.recyclerview.widget.LinearLayoutManager
//import com.comst19.viewbindingrvadapter.R
//import com.comst19.viewbindingrvadapter.databinding.ActivityViewBindingBinding
//
//class ViewBindingActivity : AppCompatActivity() {
//
//    private  lateinit var binding : ActivityViewBindingBinding
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        binding = ActivityViewBindingBinding.inflate(layoutInflater)
//        val view = binding.root
//        setContentView(view)
//
//        val array = ArrayList<String>()
//        array.add("a")
//        array.add("b")
//        array.add("c")
//        array.add("a")
//        array.add("b")
//        array.add("c")
//        array.add("a")
//        array.add("b")
//        array.add("c")
//
//        val customViewAdapter = CustomViewAdapter(array)
//        val rv = binding.rv
//        rv.adapter = customViewAdapter
//        rv.layoutManager = LinearLayoutManager(this)
//    }
//}