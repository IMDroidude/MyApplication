package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.example.myapplication.common.AlertStore
import com.example.myapplication.common.BaseActivity
import com.example.myapplication.ext.listen
import com.example.myapplication.splash.SplashViewModel
import javax.inject.Inject

///@ContributesActivity
class Splashy : BaseActivity<SplashViewModel>() {

    ///private lateinit var viewModel:SplashViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ///AndroidInjection.inject(this) // No need to call when extends with DaggerAppCompatActivity
        setContentView(R.layout.activity_splashy)

        //viewModel = getViewModel()

        ///viewModel = ViewModelProviders.of(this)[SplashViewModel::class.java]
        viewModel.onMoveToNext.listen(this){
            val intent = Intent(this, it.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
            startActivity(intent)
        }
    }
}
