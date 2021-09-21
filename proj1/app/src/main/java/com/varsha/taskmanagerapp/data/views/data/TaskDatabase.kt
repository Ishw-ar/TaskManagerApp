package com.varsha.taskmanagerapp.data.views.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase



@Database(entities = [TaskEntity::class],version = 1)
abstract class TaskDatabase :RoomDatabase(){

    //This fun is responsible for creating object of Dao class
    abstract fun getTaskDAO():TaskDAO


    companion object{
        private var INSTANCE:TaskDatabase?=null
        fun getDatabase(context: Context):TaskDatabase{
            if (INSTANCE==null){
                val builder=Room.databaseBuilder(
                    context.applicationContext,
                    TaskDatabase::class.java,
                    "Task_database"
                )
                builder.fallbackToDestructiveMigration()
                INSTANCE=builder.build()
                return INSTANCE!!
            }else{
                return INSTANCE!!
            }
        }
    }
}