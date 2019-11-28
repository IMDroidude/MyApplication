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

open abstract class BaseActivity<DB : ViewDataBinding,VM : ViewModel> : DaggerAppCompatActivity() {

    @Inject
    lateinit var mViewModel : VM

    lateinit var mBinding : DB
    abstract val layoutId : Int

    /*@Inject
    lateinit var viewModelFactory: ViewModelFactory*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        val viewModelFactory =
            ViewModelUtil.createFor<ViewModel>(mViewModel)
        mViewModel = ViewModelProvider(this, viewModelFactory).get(mViewModel::class.java)
        mBinding = DataBindingUtil.setContentView(this, layoutId)
    }

    inline fun <reified T : ViewDataBinding> getBinding(@LayoutRes layoutId: Int): T {
        return DataBindingUtil.setContentView(this, layoutId)
    }

    /*@Inject
    lateinit var factories: ViewModelProvider.Factory*/
    /*inline fun <reified T : ViewModel> getViewModel(): T {
        return ViewModelProvider(this, factories).get(T::class.java)
    }*/
}