package com.example.myapplication.fruitTest

import android.view.ViewGroup
import com.example.myapplication.R

class FruitAdapter(items: List<String>) : BaseAdapter<String>(items) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<String> {
        return FruitVH(parent, R.layout.item_fruit)
    }
}