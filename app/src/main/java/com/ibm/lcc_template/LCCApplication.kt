package com.ibm.lcc_template

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ibm.lcc_template.data.database.TodoDatabase
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class LCCApplication: Application() {}
