package com.example.shoppinglist.data.ui

import android.content.ClipData
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppinglist.R
import com.example.shoppinglist.data.db.Items
import com.example.shoppinglist.data.db.ShoppingDatabase
import com.example.shoppinglist.data.db.shopRepository.ShoppingRepository
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val database = ShoppingDatabase(context = this)
        val repository = ShoppingRepository(database)
        val factory = ShoppingViewModelfactory(repository)


        val viewModel = ViewModelProviders.of(this, factory).get(ShoppingViewModel::class.java)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        val adapter = ItemAdapter(listOf(), viewModel)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)


        viewModel.getAllItems().observe(this, Observer {
            adapter.item = it
            adapter.notifyDataSetChanged()
        })
        float_button.setOnClickListener {
            AddDialog(this,
                object : AddDialogListener {
                    override fun onAddButtonClicked(item: Items) {
                        viewModel.upsert(item)
                    }

                }).show()
        }
    }
}
