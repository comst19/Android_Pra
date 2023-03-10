package com.comst19.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.comst19.room.adapter.CustomAdapter
import com.comst19.room.db.TextDatabase
import com.comst19.room.entity.TextEntity
import com.comst19.room.entity.WordEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.getData()

        val db = TextDatabase.getDatabase(this)


        val inputArea = findViewById<EditText>(R.id.textinputArea)
        val insertBtn = findViewById<Button>(R.id.insert)
        val getAllBtn = findViewById<Button>(R.id.getData)
        val deleteBtn = findViewById<Button>(R.id.delete)

        insertBtn.setOnClickListener {

            viewModel.insertData(inputArea.text.toString())
            inputArea.setText("")
            // ViewModel 사용하기 전
//            CoroutineScope(Dispatchers.IO).launch {
//                db.textDao().insert(TextEntity(0, inputArea.text.toString()))
//                db.wordDao().insert(WordEntity(0, inputArea.text.toString()))
//                inputArea.setText("")
//            }
        }

        val rv = findViewById<RecyclerView>(R.id.rv)
        viewModel.textList.observe(this, Observer {
            val customAdapter = CustomAdapter(it)
            rv.adapter = customAdapter
            rv.layoutManager = LinearLayoutManager(this)
        })

        getAllBtn.setOnClickListener {
            viewModel.getData()
            // ViewModel 사용하기 전
//            CoroutineScope(Dispatchers.IO).launch{
//                Log.d("MainActivity", db.textDao().getAllData().toString())
//                Log.d("MainActivity", db.wordDao().getAllData().toString())
//            }
        }

        deleteBtn.setOnClickListener {
            viewModel.removeData()
            // ViewModel 사용하기 전
//            CoroutineScope(Dispatchers.IO).launch{
//                db.textDao().deleteAllData()
//                db.wordDao().deleteAllData()
//            }
        }


    }
}