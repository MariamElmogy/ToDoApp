package com.example.android11

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.android11.base.BaseActivty
import com.example.android11.database.TasksDatabase
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : BaseActivty() {
    lateinit var adapter: TasksAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        add_btn.setOnClickListener{
            openAddTaskActivity()
        }
        initUpRecyclerView()

    }

    private fun initUpRecyclerView() {
        adapter = TasksAdapter(listOf())
        recycler_view.adapter = adapter
    }

    override fun onStart() {
        super.onStart()
        val tasks = TasksDatabase.getInstance(applicationContext)
            .tasksDao()
            .getAllTasks()
        adapter.changeData(tasks)
    }

    private fun openAddTaskActivity() {
        val intent = Intent(this, AddTasksActivity::class.java)
        startActivity(intent)
    }
}