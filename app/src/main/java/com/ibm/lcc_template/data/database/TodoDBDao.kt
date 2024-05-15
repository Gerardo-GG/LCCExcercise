package com.ibm.lcc_template.data.database

import androidx.core.view.WindowInsetsCompat.Type.InsetsType
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.ibm.lcc_template.data.model.TodoItem

@Dao
interface TodoDBDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(item: Array<TodoItem>)

    @Query("SELECT * FROM TodoItem WHERE id = :id")
    suspend fun getData(id: Int): TodoItem

    @Update
    suspend fun update(item: TodoItem)

}