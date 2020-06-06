package com.example.shoppinglist.data.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.shoppinglist.data.db.shopRepository.ShoppingRepository

class ShoppingViewModelfactory(private val repository: ShoppingRepository):ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ShoppingViewModel(repository) as T
    }

}