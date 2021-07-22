package com.example.taskmanagerapp.data.views.data

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface TaskDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(taskEntity: TaskEntity)

    @Query("select * from taskapp")
    fun getTask():LiveData<List<TaskEntity>>

    @Update
    fun updateTask(taskEntity: TaskEntity)

    @Delete
    fun deleteTask(taskEntity: TaskEntity)
}