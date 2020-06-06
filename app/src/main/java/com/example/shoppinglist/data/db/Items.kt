package com.example.shoppinglist.data.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="Items")
data class Items (
    @ColumnInfo(name="Item_name")
    var Name: String ,
    @ColumnInfo(name="Item_qty")
    var qty: Int,
    @ColumnInfo(name="Price")
    var price: Int
){
    @PrimaryKey(autoGenerate = true)
    var id:Int?=null
}