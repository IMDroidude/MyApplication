package com.example.myapplication.common.genericAdapter;

import android.view.View;

public interface OnAdapterBind<T> {
    ///GeneralViewHolder setViewHolder(ViewGroup parent,int viewType);
    void onBindData(View itemView, T data);
    int setLayoutId(int position,T obj);
    void onItemClicked(int position,View mView);
}
