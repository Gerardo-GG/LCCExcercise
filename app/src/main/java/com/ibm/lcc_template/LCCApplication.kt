package com.ibm.lcc_template

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ibm.lcc_template.data.database.TodoDatabase

class LCCApplication: Application() {

    lateinit var room: TodoDatabase

    override fun onCreate() {
        super.onCreate()

        room = Room
            .databaseBuilder(applicationContext, TodoDatabase::class.java, "TODODB")
            .build()
    }

}