package com.varsha.taskmanagerapp.data.views.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.varsha.taskmanagerapp.data.views.data.TaskEntity
import com.varsha.taskmanagerapp.data.views.repository.MyRepository

class MyViewModels (val myRepository: MyRepository):ViewModel(){
    fun addTasks(taskEntity: TaskEntity){
        myRepository.addTask(taskEntity)
    }


    fun getTasks(): LiveData<List<TaskEntity>> {
        return myRepository.getTask()
    }

    fun updateTasks(taskEntity: TaskEntity){
        myRepository.updateTask(taskEntity)
    }
    fun deleteTask(taskEntity: TaskEntity){
        myRepository.deleteTask(taskEntity)
    }
}