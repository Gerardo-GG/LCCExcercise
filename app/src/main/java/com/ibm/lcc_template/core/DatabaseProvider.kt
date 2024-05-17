package com.ibm.lcc_template.core

import android.content.Context
import androidx.room.Room
import com.ibm.lcc_template.data.database.ProductDao
import com.ibm.lcc_template.data.database.ProductDatabase
import com.ibm.lcc_template.utils.Constants
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseProvider {

    @Singleton
    @Provides
    fun getDatabaseProvider(@ApplicationContext context: Context): ProductDatabase {
        return Room.databaseBuilder(context, ProductDatabase::class.java, Constants.DATABASE_NAME)
            .build()
    }

    @Singleton
    @Provides
    fun getProductDao(database: ProductDatabase): ProductDao {
        return database.getDatabaseDao()
    }

}