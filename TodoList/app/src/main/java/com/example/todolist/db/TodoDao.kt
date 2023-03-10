package com.example.todolist.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TodoDao {

    //get All
    @Query("SELECT * FROM TodoEntity ORDER BY importance") // 중요도 순으로 배열
    fun getAllTodo() : List<TodoEntity>

    //insert_todo
    @Insert
    fun insertTodo(todo : TodoEntity)

    //delete_todo
    @Delete
    fun deleteTodo(todo : TodoEntity)
}