package com.comst19.simpleretrofitex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val api = RetrofitInstance.getInstance().create(MyApi::class.java)

        // 이 방법으로하면 코드의 가독성이 매우 떨어짐 => 코루틴 사용
        api.getPost1().enqueue(object : Callback<Post>{
            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                Log.d("API1", response.body().toString())
                api.getPostNumber(2).enqueue(object : Callback<Post>{
                    override fun onResponse(call: Call<Post>, response: Response<Post>) {
                        Log.d("API2", response.body().toString())
                        api.getPostNumber(3).enqueue(object : Callback<Post>{
                            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                                Log.d("API3", response.body().toString())
                                api.getPostNumber(4).enqueue(object : Callback<Post>{
                                    override fun onResponse(call: Call<Post>, response: Response<Post>) {
                                        Log.d("API4", response.body().toString())
                                    }

                                    override fun onFailure(call: Call<Post>, t: Throwable) {
                                        Log.d("API4", "fail")
                                    }

                                })
                            }

                            override fun onFailure(call: Call<Post>, t: Throwable) {
                                Log.d("API3", "fail")
                            }

                        })
                    }

                    override fun onFailure(call: Call<Post>, t: Throwable) {
                        Log.d("API2", "fail")
                    }

                })
            }

            override fun onFailure(call: Call<Post>, t: Throwable) {
                Log.d("API1", "fail")
            }

        })
        // 아래의 코드로 하면 순차적으로 되지가 않음
//        api.getPostNumber(2).enqueue(object : Callback<Post>{
//            override fun onResponse(call: Call<Post>, response: Response<Post>) {
//                Log.d("API2", response.body().toString())
//            }
//
//            override fun onFailure(call: Call<Post>, t: Throwable) {
//                Log.d("API2", "fail")
//            }
//
//        })
//
//        api.getPostNumber(3).enqueue(object : Callback<Post>{
//            override fun onResponse(call: Call<Post>, response: Response<Post>) {
//                Log.d("API3", response.body().toString())
//            }
//
//            override fun onFailure(call: Call<Post>, t: Throwable) {
//                Log.d("API3", "fail")
//            }
//
//        })
//
//        api.getPostNumber(4).enqueue(object : Callback<Post>{
//            override fun onResponse(call: Call<Post>, response: Response<Post>) {
//                Log.d("API4", response.body().toString())
//            }
//
//            override fun onFailure(call: Call<Post>, t: Throwable) {
//                Log.d("API4", "fail")
//            }
//
//        })
    }
}