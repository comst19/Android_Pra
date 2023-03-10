package com.comst19.mapswitchmap

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {


    private var _mutableCount = MutableLiveData(0)
    val liveCount : LiveData<Int>
        get() = _mutableCount

    fun setLiveDataValue(count : Int){
        _mutableCount.value = count
    }

    // Transformations -> map / switchMap

    // map -> 값을 return

    val mapLiveData = Transformations.map(liveCount){
        it+it
    }

    fun changeValue(count : Int) : MutableLiveData<Int>{
        val testLiveData = MutableLiveData(count*count)
        return testLiveData
    }

    val switchMapLiveData = Transformations.switchMap(liveCount){
        changeValue(it)
    }

}