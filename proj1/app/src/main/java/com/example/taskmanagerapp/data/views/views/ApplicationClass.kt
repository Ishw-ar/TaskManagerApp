package com.example.taskmanagerapp.data.views.views

import android.app.Application
import com.example.taskmanagerapp.data.views.data.TaskDatabase
import com.example.taskmanagerapp.data.views.repository.MyRepository

class ApplicationClass:Application() {
    val taskDAO by lazy {
        val roomDatabase =TaskDatabase.getDatabase(this)
        roomDatabase.getTaskDAO()
    }
    val myRepository by lazy {
        MyRepository(taskDAO)
    }

}