package com.example.todojetpackcomposemvvm.data

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.todojetpackcomposemvvm.data.models.ToDoTask

@Database(entities = [ToDoTask::class], version = 1, exportSchema = false)
abstract class ToDoDatabase : RoomDatabase() {
    abstract fun todoDao(): ToDoDao
}