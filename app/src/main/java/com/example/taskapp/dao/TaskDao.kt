package com.example.taskapp.dao

import androidx.room.*
import com.example.taskapp.models.Task
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {


    @Query("SELECT * FROM Task ORDER BY date DESC")
    fun getTaskList() : Flow<List<Task>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTask(task: Task): Long

    //first way
    @Delete
    suspend fun deleteTask(task: Task) : Int


    //second way
    @Query("DELETE FROM Task WHERE taskId == :taskId")
    suspend fun deleteTaskUsingId(taskId: String) : Int


    @Update
    suspend fun updateTask(task: Task): Int

    @Query("UPDATE Task SET taskTitle=:title, description = :description WHERE taskId = :taskId")
    suspend fun updateTaskPaticularField(taskId: String,title:String,description:String): Int

    @Query("SELECT * FROM Task WHERE taskTitle LIKE :query ORDER BY date DESC")
    fun searchTaskList(query: String) : Flow<List<Task>>
}