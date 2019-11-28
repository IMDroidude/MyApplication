package com.example.myapplication.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.common.AlertStore


class MainModelFactory(private val alertStore: AlertStore) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(alertStore) as T
    }
}