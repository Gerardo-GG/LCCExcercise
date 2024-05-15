package com.ibm.lcc_template.core.di

import android.content.Context
import androidx.room.Room
import com.ibm.lcc_template.data.database.TodoDBDao
import com.ibm.lcc_template.data.database.TodoDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun databaseProvider(@ApplicationContext context: Context): TodoDatabase {
        return Room
            .databaseBuilder(context, TodoDatabase::class.java, "TODODB")
            .build()
    }

    @Singleton
    @Provides
    fun todosDaoProvider(database: TodoDatabase): TodoDBDao {
        return database.interfaceDao()
    }
}