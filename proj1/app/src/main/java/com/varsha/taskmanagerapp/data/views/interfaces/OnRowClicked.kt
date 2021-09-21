package com.varsha.taskmanagerapp.data.views.interfaces

import com.varsha.taskmanagerapp.data.views.data.TaskEntity

interface OnRowClicked {
    fun onEditButtonOnClicked(taskEntity: TaskEntity)
    fun onDeleteButtonOnClicked(taskEntity: TaskEntity)

}