package com.example.restinoapp.data.model

import android.net.Uri
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.net.URL

@Entity(tableName = "product_table")
data class Product(

    @PrimaryKey(autoGenerate = true)
    var id: Long?=null,
    var image: Int,
    var name: String,
    var price: Float,
    var inventory: Int
)
