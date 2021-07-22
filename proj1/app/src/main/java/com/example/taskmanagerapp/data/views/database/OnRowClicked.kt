package com.example.taskmanagerapp.data.views.database

import com.example.taskmanagerapp.data.views.data.TaskEntity

interface OnRowClicked {
    fun onEditButtonOnClicked(taskEntity: TaskEntity)
    fun onDeleteButtonOnClicked(taskEntity: TaskEntity)

}