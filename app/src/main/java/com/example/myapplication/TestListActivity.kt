package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.myapplication.common.BaseActivity
import com.example.myapplication.common.genericAdapter.GenericAdapter
import com.example.myapplication.common.genericAdapter.OnAdapterBind
import com.example.myapplication.databinding.ActivityTestListBinding
import com.example.myapplication.testlit.TestListModel
import kotlinx.android.synthetic.main.activity_test_list.*
import kotlinx.android.synthetic.main.item_test.*

class TestListActivity : BaseActivity<ActivityTestListBinding, TestListModel>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val carList = listOf<String>("Moras", "honda", "audi",
            "Moras", "honda", "audi","Moras", "honda", "audi",
            "Moras", "honda", "audi","Moras", "honda", "audi",
            "Moras", "honda", "audi","Moras", "honda", "audi")

        recyclerView.adapter = GenericAdapter<String>( carList, object : OnAdapterBind<String> {

            override fun onBindData(itemView: View?, data: String?) {
                carNameTv.text = ""
            }

            override fun setLayoutId(position: Int, obj: String?): Int = R.layout.item_test

            override fun onItemClicked(position: Int, mView: View?) {
                Toast.makeText(this@TestListActivity,"Clicked -> " + position,Toast.LENGTH_LONG).show()
            }
        })
    }

    override val layoutId: Int
        get() = R.layout.activity_test_list
}
