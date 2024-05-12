package com.example.lab_exam_04.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.lab_exam_04.converters.TypeConverter
import com.example.lab_exam_04.models.Task

@Database(
    entities = [Task::class],
    version = 1
)
@TypeConverters(TypeConverter::class)
abstract class TaskDataBase : RoomDatabase() {
    companion object{
        @Volatile
        private var INSTANCE: TaskDataBase? = null
        fun getInstance(context: Context): TaskDataBase{
            synchronized(this){
                return INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    TaskDataBase::class.java,
                    name = "task_db"
                ).build().also{
                    INSTANCE = it
                }
            }
        }
    }
}