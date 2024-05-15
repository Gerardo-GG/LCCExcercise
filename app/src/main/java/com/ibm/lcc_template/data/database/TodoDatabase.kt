package com.ibm.lcc_template.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ibm.lcc_template.data.model.TodoItem

@Database(
    entities = [TodoItem::class],
    version = 1
)
abstract class TodoDatabase: RoomDatabase() {
    abstract fun interfaceDao(): TodoDBDao
}