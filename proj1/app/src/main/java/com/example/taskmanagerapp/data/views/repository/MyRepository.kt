package com.example.taskmanagerapp.data.views.repository

import androidx.lifecycle.LiveData
import com.example.taskmanagerapp.data.views.data.TaskDAO
import com.example.taskmanagerapp.data.views.data.TaskEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MyRepository(val taskDAO: TaskDAO) {
    fun addTask(taskEntity: TaskEntity){
        CoroutineScope(Dispatchers.IO).launch {
            taskDAO.insert(taskEntity)
        }
    }
    fun getTask():LiveData<List<TaskEntity>>{
        return taskDAO.getTask()
    }

    fun updateTask(taskEntity: TaskEntity){
        CoroutineScope(Dispatchers.IO).launch {
            taskDAO.updateTask(taskEntity)
        }
    }
    fun deleteTask(taskEntity: TaskEntity){
        CoroutineScope(Dispatchers.IO).launch {
            taskDAO.deleteTask(taskEntity)
        }
    }
}