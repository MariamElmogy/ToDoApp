package com.example.android11.database.dao

import androidx.room.*
import com.example.android11.database.model.Task

@Dao
interface TasksDao {
    // add task
    @Insert
    fun addTask(task:Task)
    //update task
    @Update
    fun updateTask(task:Task)
    // delete task
    @Delete
    fun deleteTask(task: Task)
    // get all tasks
    @Query("select * from Task")
    fun getAllTasks():List<Task>
    //search for task
    @Query("select * from Task where title like :word or description like :word")
    fun searchForTasks(word:String):List<Task>
}