package com.comst19.room

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.comst19.room.db.TextDatabase
import com.comst19.room.entity.TextEntity
import com.comst19.room.entity.WordEntity
import com.comst19.room.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {

    val context = getApplication<Application>().applicationContext
    val db = TextDatabase.getDatabase(context)

    private var _textList = MutableLiveData<List<TextEntity>>()
    val textList : LiveData<List<TextEntity>>
        get() = _textList

    private var _wordList = MutableLiveData<List<WordEntity>>()
    val wordList : LiveData<List<WordEntity>>
        get() = _wordList

    val repository = Repository(context)

    fun getData() = viewModelScope.launch(Dispatchers.IO) {

        Log.d("MainViewModel", db.textDao().getAllData().toString())
        Log.d("MainViewModel", db.wordDao().getAllData().toString())
        _textList.postValue(repository.getTextList())
        _wordList.postValue(repository.getWordList())
        // Repository 사용 전
//        _textList.postValue(db.textDao().getAllData())
//        _wordList.postValue(db.wordDao().getAllData())
    }

    fun insertData(text : String) = viewModelScope.launch(Dispatchers.IO) {
        repository.insertTextData(text)
        repository.insertWordData(text)
        // Repository 사용 전
//        db.textDao().insert(TextEntity(0, text))
//        db.wordDao().insert(WordEntity(0, text))
    }

    fun removeData() = viewModelScope.launch(Dispatchers.IO) {
        repository.deleteTextData()
        repository.deleteWordData()
        // Repository 사용 전
//        db.textDao().deleteAllData()
//        db.wordDao().deleteAllData()
    }
}