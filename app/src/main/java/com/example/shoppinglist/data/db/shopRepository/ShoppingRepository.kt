package com.example.shoppinglist.data.db.shopRepository

import com.example.shoppinglist.data.db.Items
import com.example.shoppinglist.data.db.ShoppingDatabase

class ShoppingRepository(private val db:ShoppingDatabase) {

    suspend fun upsert(item: Items)=db.getShoppingDao().upsert(item)
    suspend fun delete(item: Items)=db.getShoppingDao().delete(item)
    fun getAllItems()=db.getShoppingDao().getAllItems()
}