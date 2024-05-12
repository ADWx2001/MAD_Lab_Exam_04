package com.example.lab_exam_04.converters

import androidx.room.TypeConverter
import java.util.Date

class TypeConverter {
    @TypeConverter
    fun fromTimeStamp(value:Long): Date {
        return Date(value)
    }

    @TypeConverter
    fun dateToTimeStamp(date:Date): Long {
        return date.time
    }
}