package com.comst19.retrofitviewmodelscoperecyclerviewglide.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.comst19.retrofitviewmodelscoperecyclerviewglide.api.MyApi
import com.comst19.retrofitviewmodelscoperecyclerviewglide.api.RetrofitInstance
import com.comst19.retrofitviewmodelscoperecyclerviewglide.model.Plant
import com.comst19.retrofitviewmodelscoperecyclerviewglide.repository.Repository
import kotlinx.coroutines.launch

class MainViewModel : ViewModel(){

    //val retrofitInstance : MyApi = RetrofitInstance.getInstance().create(MyApi::class.java)

    private val repository = Repository()

    private val _result = MutableLiveData<List<Plant>>()
    val result : LiveData<List<Plant>>
        get() = _result

    fun getAllData () = viewModelScope.launch {
        //Log.d("MainViewModel",retrofitInstance.getAllPlants().toString())
        // => Log.d("MainViewModel",repository.getAllData().toString())
        _result.value = repository.getAllData()
    }
}