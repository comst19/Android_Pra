package com.example.todolist.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(TodoEntity::class), version = 1) // 조건 1
abstract class AppDatabase : RoomDatabase(){ // 조건 2
    abstract fun getTodoDao() : TodoDao //조건 3 : TodoDao를 반환하고 인수가 존재하지 않는 추상함수

    companion object{ //Singleton Pattern 프로그램 내에서 객체 하나를 공유하는 패턴
        val databaseName = "db_todo"
        var appDatabase : AppDatabase? = null

        fun getInstance(context : Context) : AppDatabase?{
            if(appDatabase == null){
                appDatabase = Room.databaseBuilder(context,
                    AppDatabase::class.java,
                    databaseName).
                fallbackToDestructiveMigration()
                    .build()

            }

            return appDatabase
        }
    }
}