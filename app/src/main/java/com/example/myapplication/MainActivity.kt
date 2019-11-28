package com.example.myapplication

import android.os.Bundle
import com.example.myapplication.common.AlertStore
import com.example.myapplication.common.BaseActivity
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.home.MainViewModel
import com.example.myapplication.testpackage.TestClass
import dagger.android.AndroidInjection
import javax.inject.Inject

///@ContributesActivity
class MainActivity : BaseActivity<ActivityMainBinding,MainViewModel>() {

    @Inject lateinit var alertStore: AlertStore

    @Inject
    lateinit var testClass: TestClass

    ///private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        ///alertStore.showToast("Hello")
        testClass.getRandomValueFromCTest()

        ///viewModel = getViewModel()
        mViewModel.showDialog()

        //viewModel = ViewModelProviders.of(this,MainModelFactory(AlertStore(this@MainActivity)))[MainViewModel::class.java]

        //viewModel.showDialog()

        //viewModel.equals("").and()
    }

    override val layoutId: Int
        get() = R.layout.activity_main
}
