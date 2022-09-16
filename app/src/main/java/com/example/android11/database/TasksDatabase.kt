package com.example.android11.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.android11.database.dao.TasksDao
import com.example.android11.database.model.Task

@Database(entities = [Task::class], version = 1, exportSchema = false)
abstract class TasksDatabase :RoomDatabase(){

    abstract fun tasksDao(): TasksDao //annotation processor

    //database object

    //singleton -> class -> construct single object
    //companion object (static in java)
    companion object{
        private var database:TasksDatabase?=null
        private var DATABASE_NAME = "tasks-db"
        fun getInstance(context: Context):TasksDatabase{
            if(database==null){ //first time
                //create
                database = Room.databaseBuilder(context,
                    TasksDatabase::class.java, DATABASE_NAME)
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()
            }
            return database!!
        }
    }
}