package com.example.android11.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity
data class Task(
    @ColumnInfo (name = "Id") @PrimaryKey (autoGenerate = true) var id:Int?=null,
    @ColumnInfo var title:String?=null,
    @ColumnInfo var description:String?=null,
    @ColumnInfo var isCompleted:Boolean?=false
)
