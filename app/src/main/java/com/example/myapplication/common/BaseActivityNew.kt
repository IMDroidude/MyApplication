package com.example.myapplication.common

import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class BaseActivityNew <T : ViewModel>: DaggerAppCompatActivity() {

    /*@Inject
    lateinit var factories: ViewModelProvider.Factory*/

    @Inject
    lateinit var mViewModel: T

    /*val model by viewModel<T>()*/

    /*@Inject
    lateinit var viewModelFactory: ViewModelFactory*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        //getViewModel<T>()
    }

    inline fun <reified T : ViewDataBinding> getBinding(@LayoutRes layoutId: Int): T {
        return DataBindingUtil.setContentView(this, layoutId)
    }

    /*inline fun <reified T : ViewModel> getViewModel(): T {
        return ViewModelProvider(this, factories).get(T::class.java)
    }*/
}