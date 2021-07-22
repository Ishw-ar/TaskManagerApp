package com.example.taskmanagerapp

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.taskmanagerapp.data.local.ExpenseDAO
import com.example.taskmanagerapp.data.local.ExpenseDatabase
import com.example.taskmanagerapp.data.local.ExpenseEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config


@RunWith(AndroidJUnit4::class)
@Config(manifest = Config.NONE)
class ExpensesTest {

    lateinit var database: ExpenseDatabase
    lateinit var dao: ExpenseDAO

    @Before
    fun setUp(){
       val context=ApplicationProvider.getApplicationContext<Context>()
        database=Room.inMemoryDatabaseBuilder(context,ExpenseDatabase::class.java)
            .build()
        dao=database.getMyExpenseDAO()
    }

    @Test
    fun insertExpensesTest(){
     val entity=ExpenseEntity("Salary","Income",12345)
        CoroutineScope(Dispatchers.IO).launch {
            dao.insert(entity)
        }

        val expenses=dao.getExpenses()
        expenses.value?.let {
            assert(it.isNotEmpty())
        }

    }

}