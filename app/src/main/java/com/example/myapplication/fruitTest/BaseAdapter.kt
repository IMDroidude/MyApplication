package com.example.myapplication.fruitTest

import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<T>(protected val items: List<T>) : RecyclerView.Adapter<BaseViewHolder<T>>() {

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: BaseViewHolder<T>, position: Int) {
        holder.bindData(items.get(position))
    }
}