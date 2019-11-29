package com.example.myapplication.fruitTest

import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_fruit.view.*


class FruitVH(parent: ViewGroup, layoutId: Int) : BaseViewHolder<String>(parent, layoutId) {

    override fun bindData(data: String) {
        itemView.fruitTv.text = data
    }
}