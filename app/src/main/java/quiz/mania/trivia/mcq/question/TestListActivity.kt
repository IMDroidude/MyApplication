package quiz.mania.trivia.mcq.question

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Toast
import quiz.mania.trivia.mcq.question.common.BaseActivity
import quiz.mania.trivia.mcq.question.common.genericAdapter.GenericAdapter
import quiz.mania.trivia.mcq.question.common.genericAdapter.OnAdapterBind
import quiz.mania.trivia.mcq.question.testlit.TestListModel
import kotlinx.android.synthetic.main.activity_test_list.*
import kotlinx.android.synthetic.main.item_test.*
import org.json.JSONObject
import quiz.mania.trivia.mcq.question.databinding.ActivityTestListBinding
import quiz.mania.trivia.mcq.question.fruitTest.FruitActivity
import quiz.mania.trivia.mcq.question.mixpanelz.AnalyticsManager

class TestListActivity : BaseActivity<ActivityTestListBinding, TestListModel>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        AnalyticsManager(this@TestListActivity).trackEvent("Visited Car List")
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

                val jsonObject = JSONObject()
                jsonObject.put("carName",carList.get(position))
                AnalyticsManager(this@TestListActivity).trackEvent("Selected Car",jsonObject)
            }
        })

        Handler().postDelayed({
            startActivity(Intent(this@TestListActivity,FruitActivity::class.java))
        },500)
    }

    override val layoutId: Int
        get() = R.layout.activity_test_list
}
