package com.ibm.lcc_template.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ibm.lcc_template.data.model.Product

@Database(
    entities = [Product::class],
    version = 1
)
abstract class ProductDatabase: RoomDatabase() {

    abstract fun getDatabaseDao(): ProductDao

}