package com.ibm.lcc_template.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity()
data class TodoItem(
    @PrimaryKey
    val id: Int,
    val title: String,
    var completed: Boolean
)
