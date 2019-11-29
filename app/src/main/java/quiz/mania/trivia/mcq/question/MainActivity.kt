package quiz.mania.trivia.mcq.question

import android.os.Bundle
import quiz.mania.trivia.mcq.question.common.AlertStore
import quiz.mania.trivia.mcq.question.common.BaseActivity
import quiz.mania.trivia.mcq.question.databinding.ActivityMainBinding
import quiz.mania.trivia.mcq.question.home.MainViewModel
import quiz.mania.trivia.mcq.question.testpackage.TestClass
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
