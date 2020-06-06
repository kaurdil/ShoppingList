package com.example.shoppinglist.data.ui

import android.content.Context
import android.os.Bundle
import android.view.Window
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.example.shoppinglist.R
import com.example.shoppinglist.data.db.Items
import kotlinx.android.synthetic.main.add_items.*

class AddDialog(context: Context,var addDialogListener: AddDialogListener): AppCompatDialog(context) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.add_items)
        add.setOnClickListener{
            val name=name.text.toString()
            val qty=qty.text.toString()
            val price:String=price.text.toString()
            if(name.isEmpty() || qty.isEmpty() || price.isEmpty())
            {
                Toast.makeText(context,"plz fill all Enteries",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val item= Items(name,qty.toInt(),price.toInt())
            addDialogListener.onAddButtonClicked(item)
            dismiss()
        }
        cancell.setOnClickListener { cancel() }
    }
}