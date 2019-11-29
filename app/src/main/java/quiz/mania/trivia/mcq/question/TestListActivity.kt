package quiz.mania.trivia.mcq.question

import android.os.Bundle
import android.view.View
import android.widget.Toast
import quiz.mania.trivia.mcq.question.common.BaseActivity
import quiz.mania.trivia.mcq.question.common.genericAdapter.GenericAdapter
import quiz.mania.trivia.mcq.question.common.genericAdapter.OnAdapterBind
import quiz.mania.trivia.mcq.question.testlit.TestListModel
import kotlinx.android.synthetic.main.activity_test_list.*
import kotlinx.android.synthetic.main.item_test.*
import quiz.mania.trivia.mcq.question.databinding.ActivityTestListBinding

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

            override fun setLayoutId(position: Int, obj: String?): Int =
                R.layout.item_test

            override fun onItemClicked(position: Int, mView: View?) {
                Toast.makeText(this@TestListActivity,"Clicked -> " + position,Toast.LENGTH_LONG).show()
            }
        })
    }

    override val layoutId: Int
        get() = R.layout.activity_test_list
}
