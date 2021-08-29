package com.varsha.taskmanagerapp.data.views.views

import android.app.Application
import com.varsha.taskmanagerapp.data.views.data.TaskDatabase
import com.varsha.taskmanagerapp.data.views.repository.MyRepository

class ApplicationClass:Application() {
    val taskDAO by lazy {
        val roomDatabase =TaskDatabase.getDatabase(this)
        roomDatabase.getTaskDAO()
    }
    val myRepository by lazy {
        MyRepository(taskDAO)
    }

}