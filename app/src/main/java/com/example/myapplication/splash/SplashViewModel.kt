package com.example.myapplication.splash

import androidx.lifecycle.viewModelScope
import com.example.myapplication.MainActivity
import com.example.myapplication.common.BaseViewModel
import com.example.myapplication.ext.ClassLiveData
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

class SplashViewModel @Inject constructor(): BaseViewModel() {

    val onMoveToNext = ClassLiveData()
    private val mActivity = MainActivity::class

    init {
        viewModelScope.launch {
            delay(3500)

            onMoveToNext.postValue(mActivity)

        }
    }
}