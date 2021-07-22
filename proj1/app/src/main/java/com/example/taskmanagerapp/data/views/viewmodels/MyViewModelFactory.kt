package com.example.taskmanagerapp.data.views.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.taskmanagerapp.data.views.repository.MyRepository


class MyViewModelFactory(val myRepository: MyRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MyViewModels(myRepository)as T
    }
}