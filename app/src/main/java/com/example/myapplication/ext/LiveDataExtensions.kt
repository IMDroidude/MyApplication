package com.example.myapplication.ext

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.myapplication.common.WorkStatus
import kotlin.reflect.KClass


typealias ClassLiveData = MutableLiveData<KClass<*>>

typealias WorkLiveData = MutableLiveData<WorkStatus>

typealias IntLiveData = MutableLiveData<Int>


fun <T> LiveData<T>.listen(owner: LifecycleOwner, cb: (data: T) -> Unit) {
    observe(owner, Observer {
        cb.invoke(it)
    })
}