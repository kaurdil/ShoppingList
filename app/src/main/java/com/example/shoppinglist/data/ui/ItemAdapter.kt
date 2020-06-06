package com.example.shoppinglist.data.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppinglist.R
import com.example.shoppinglist.data.db.Items
import kotlinx.android.synthetic.main.shopping_items.view.*

class ItemAdapter(var item:List<Items>,
                  private var viewModel: ShoppingViewModel
                ):RecyclerView.Adapter<ItemAdapter.ShoppingViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
        val view =LayoutInflater.from(parent.context).inflate(R.layout.shopping_items,parent,false)
        return ShoppingViewHolder(view)
    }

    override fun getItemCount(): Int {
        return item.size

    }

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
        var current=item[position]
        holder.itemView.textView.text=current.Name
        holder.itemView.textView2.text= "${current.qty}"
        holder.itemView.pr.text="${current.price}"
        holder.itemView.textView5.text="Total:-₹${current.price*current.qty}"

        holder.itemView.plus.setOnClickListener(){
            current.qty++
            viewModel.upsert(current)
        }
        holder.itemView.delete.setOnClickListener(){
            viewModel.delete(current)
        }
        holder.itemView.minus.setOnClickListener(){
            if(current.qty>0) {
                current.qty--
                viewModel.upsert(current)
            }
        }

    }

    inner class ShoppingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}