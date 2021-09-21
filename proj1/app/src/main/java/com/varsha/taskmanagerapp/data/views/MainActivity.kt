package com.varsha.taskmanagerapp.data.views

import android.app.Dialog
import android.os.Bundle
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.varsha.taskmanagerapp.R
import com.varsha.taskmanagerapp.data.views.data.TaskEntity
import com.varsha.taskmanagerapp.data.views.interfaces.OnRowClicked
import com.varsha.taskmanagerapp.data.views.adapters.TaskAdapter
import com.varsha.taskmanagerapp.data.views.viewmodels.MyViewModelFactory
import com.varsha.taskmanagerapp.data.views.viewmodels.MyViewModels
import com.varsha.taskmanagerapp.data.views.views.ApplicationClass
import com.varsha.taskmanagerapp.databinding.EditDialogLayoutBinding
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), OnRowClicked {

   private lateinit var viewModels: MyViewModels
    val tasks= mutableListOf<TaskEntity>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

      val adapter2=TaskAdapter(tasks,this)
        recyclerView.layoutManager=LinearLayoutManager(this)
        recyclerView.adapter=adapter2

        val app= application as ApplicationClass
        val viewModelFactory=MyViewModelFactory(app.myRepository)
        viewModels=ViewModelProviders.of(this,viewModelFactory).get(MyViewModels::class.java)
        //viewModels=ViewModelProviders.of(this,viewModelFactory).get(MyViewModels::class.java)
        viewModels.getTasks().observe(this, Observer {
            tasks.clear()
            tasks.addAll(it)
            adapter2.notifyDataSetChanged()
        })


        btnAdd.setOnClickListener {
            val taskEntity= TaskEntity(etTitle.text.toString(),etDescription.text.toString())
            viewModels.addTasks(taskEntity)
        }
    }

    override fun onEditButtonOnClicked(taskEntity: TaskEntity) {
        val dialog=Dialog(this)
        val binding = EditDialogLayoutBinding.inflate(layoutInflater)
         dialog.setContentView(binding.root)
         dialog.show()
        val window=dialog.window
        window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT)

        binding.addTask.setOnClickListener {
            taskEntity.title=binding.titleEtd.text.toString()
            taskEntity.description=binding.typeEtd.text.toString()

            viewModels.updateTasks(taskEntity)
            dialog.dismiss()
        }



    }

    override fun onDeleteButtonOnClicked(taskEntity: TaskEntity) {
        viewModels.deleteTask((taskEntity))
    }

}

