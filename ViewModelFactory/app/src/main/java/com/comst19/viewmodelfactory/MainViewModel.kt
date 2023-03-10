package com.comst19.viewmodelfactory

import android.util.Log
import androidx.lifecycle.ViewModel

class MainViewModel(num : Int) : ViewModel() {

    init {
        Log.d("MainViewModel", num.toString())
    }

    // Repository
    // 네트워크 통신
    // LocalDB
    // Room SQLite
}