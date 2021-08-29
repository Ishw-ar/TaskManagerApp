package com.varsha.taskmanagerapp.data.views.database

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.varsha.taskmanagerapp.R
import com.varsha.taskmanagerapp.data.views.data.TaskEntity
import kotlinx.android.synthetic.main.task_item.view.*

class TaskAdapter(val tasklist:List<TaskEntity>,val listener:OnRowClicked)
    :RecyclerView.Adapter<TaskAdapter.TaskViewHolder>(){

    inner class TaskViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.task_item,parent,false)
        return TaskViewHolder(view)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.itemView.apply {
            tvTitle.text=tasklist[position].title
            tvDescription.text=tasklist[position].description
            btnDelete.setOnClickListener {
                listener.onDeleteButtonOnClicked(tasklist[position])

            }
            btnEdit.setOnClickListener {
                listener.onEditButtonOnClicked(tasklist[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return tasklist.size
    }

}