package com.example.restinoapp.data.model

import java.net.URL

data class Product (
var id :Long,
var image :URL,
var name :String,
var price:Float,
var inventory :Int
)
