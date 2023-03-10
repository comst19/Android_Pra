package com.comst19.simpleretrofiteximprovement

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.comst19.simpleretrofiteximprovement.adapter.CustomAdapter
import com.comst19.simpleretrofiteximprovement.model.Post
import com.comst19.simpleretrofiteximprovement.viewModel.MainViewModel


class MainActivity : AppCompatActivity() {

    lateinit var viewModel : MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.getPostAll()

        val rv = findViewById<RecyclerView>(R.id.rv)
        viewModel.liveWordList.observe(this, Observer {
            val customAdapter = CustomAdapter(it as ArrayList<Post>)
            rv.adapter = customAdapter
            rv.layoutManager = LinearLayoutManager(this)
        })
//        viewModel.getPost1()
//        viewModel.getPostNumber(3)
//
//        val area1 = findViewById<TextView>(R.id.area1)
//        val area2 = findViewById<TextView>(R.id.area2)
//
//        viewModel.liveWord1.observe(this, Observer {
//            area1.text = it.toString()
//        })
//
//        viewModel.liveWord2.observe(this, Observer {
//            area2.text = it.toString()
//        })


    }
}