package com.example.android11

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import com.example.android11.base.BaseActivty
import com.example.android11.database.TasksDatabase
import com.example.android11.database.model.Task
import kotlinx.android.synthetic.main.activity_add_tasks.*

class AddTasksActivity : BaseActivty() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_tasks)
        setUpViews()
        save_btn.setOnClickListener{
            addTask()
        }
    }

    private fun setUpViews() {
        title_layout.editText?.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(p0: Editable?) {
                title_layout.error=null
            }

        })

        desc_layout.editText?.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(p0: Editable?) {
                desc_layout.error=null
            }

        })
    }

    private fun addTask() {
        if(!validData()) return
        val taskTitle = title_layout.editText?.text.toString()
        val taskDesc = desc_layout.editText?.text.toString()
        var task = Task(title = taskTitle, description = taskDesc, isCompleted = completed.isChecked)

        TasksDatabase.getInstance(context = applicationContext)
            .tasksDao()
            .addTask(task)
        showDialog(messageId = R.string.task_added_successfully,
        posActionName=R.string.ok,
        posAction=DialogInterface.OnClickListener { dialog, which ->
            dialog.dismiss()
            finish()
        })
    }

    private fun validData(): Boolean {
        var isValid = true
        if(title_layout.editText?.text.toString().isBlank()){
            isValid=false
            title_layout.error = "please enter valid title"
        }
        if(desc_layout.editText?.text.toString().isBlank()){
            isValid=false
            desc_layout.error = "please enter valid description"
        }
        return isValid
    }
}