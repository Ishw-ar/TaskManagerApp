package com.example.taskmanagerapp.data.views.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "TaskApp")
class TaskEntity (
    @ColumnInfo(name = "title")var title:String,
    @ColumnInfo(name = "description")var description:String
)
{
    @PrimaryKey(autoGenerate = true)@ColumnInfo(name = "id") var id:Int?=null
}