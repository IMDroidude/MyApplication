package com.example.myapplication.common.genericAdapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class GenericAdapter<T>(protected val items: List<T>, val adapterBind: OnAdapterBind<T>)
    : RecyclerView.Adapter<GeneralViewHolder<T>>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GeneralViewHolder<T> =
        GeneralViewHolder(
            parent,
            viewType
        ) { position, mView ->
            adapterBind.onItemClicked(position, mView)
        }

    override fun getItemCount(): Int = items.size
    override fun getItemViewType(position: Int): Int = adapterBind.setLayoutId(position, items[position]);

    override fun onBindViewHolder(holder: GeneralViewHolder<T>, position: Int) {
        adapterBind.onBindData(holder.itemView, items[position])
    }
}