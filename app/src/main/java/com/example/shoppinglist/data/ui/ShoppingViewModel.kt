package com.example.shoppinglist.data.ui

import androidx.lifecycle.ViewModel
import com.example.shoppinglist.data.db.Items
import com.example.shoppinglist.data.db.shopRepository.ShoppingRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShoppingViewModel(private val repository: ShoppingRepository) : ViewModel()
{
    fun upsert(item: Items)= CoroutineScope(Dispatchers.Main).launch{
        repository.upsert(item)
    }

    fun delete(item: Items)= CoroutineScope(Dispatchers.Main).launch {
        repository.delete(item)
    }
    fun getAllItems()= repository.getAllItems()
}