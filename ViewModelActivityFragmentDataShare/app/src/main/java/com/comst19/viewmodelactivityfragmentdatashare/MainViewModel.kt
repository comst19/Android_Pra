package com.comst19.viewmodelactivityfragmentdatashare

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    var countValue = 0

    fun plus() {
        countValue++
    }

    fun minus(){
        countValue--
    }

    fun getCount() : Int{
        return countValue
    }
}