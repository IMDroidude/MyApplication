package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.example.myapplication.common.AlertStore
import com.example.myapplication.common.BaseActivity
import com.example.myapplication.databinding.ActivitySplashyBinding
import com.example.myapplication.ext.listen
import com.example.myapplication.splash.SplashViewModel
import javax.inject.Inject

///@ContributesActivity
class Splashy : BaseActivity<ActivitySplashyBinding,SplashViewModel>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mViewModel.onMoveToNext.listen(this){
            val intent = Intent(this, it.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
            startActivity(intent)
        }
    }

    override val layoutId: Int
        get() = R.layout.activity_splashy
}
