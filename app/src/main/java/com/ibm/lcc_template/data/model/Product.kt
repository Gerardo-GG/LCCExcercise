package com.ibm.lcc_template.data.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Product(
    @PrimaryKey
    val id: String,
    val title: String,
    // Precio double por presicion
    val price: Double,
    val description: String,
    val image: String,
    @Embedded
    val rating: Rating
)

data class Rating(
    val rate: Double
)
