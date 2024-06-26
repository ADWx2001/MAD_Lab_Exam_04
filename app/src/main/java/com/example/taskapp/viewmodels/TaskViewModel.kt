package com.example.taskapp.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.taskapp.models.Task
import com.example.taskapp.repository.TaskRepository
import com.example.taskapp.utils.Resource

class TaskViewModel(application: Application) : AndroidViewModel(application) {

    private val taskRepository = TaskRepository(application)

    val taskStateFlow get() = taskRepository.taskStateFlow
    val statusLiveData get() = taskRepository.statusLiveData

    fun getTaskList() {
        taskRepository.getTaskList()
    }




    fun insertTask(task: Task){
         taskRepository.insertTask(task)
    }

    fun deleteTask(task: Task) {
         taskRepository.deleteTask(task)
    }

    fun deleteTaskUsingId(taskId: String) {
         taskRepository.deleteTaskUsingId(taskId)
    }

    fun updateTask(task: Task){
         taskRepository.updateTask(task)
    }

    fun updateTaskPaticularField(taskId: String,title:String,description:String) {
         taskRepository.updateTaskPaticularField(taskId, title, description)
    }

    fun searchTaskList(query: String){
        taskRepository.searchTaskList(query)
    }
}