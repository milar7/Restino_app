package com.example.restinoapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.net.URL

@Entity(tableName = "product_table")
data class Product(
    @PrimaryKey
    var id: Long,
    var image: URL,
    var name: String,
    var price: Float,
    var inventory: Int
)
