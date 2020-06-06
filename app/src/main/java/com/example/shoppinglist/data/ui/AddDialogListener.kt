package com.example.shoppinglist.data.ui

import com.example.shoppinglist.data.db.Items

interface AddDialogListener {
    fun onAddButtonClicked(item:Items)
}