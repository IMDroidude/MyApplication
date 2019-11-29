package quiz.mania.trivia.mcq.question

import android.content.Intent
import android.os.Bundle
import quiz.mania.trivia.mcq.question.common.BaseActivity
import quiz.mania.trivia.mcq.question.databinding.ActivitySplashyBinding
import quiz.mania.trivia.mcq.question.ext.listen
import quiz.mania.trivia.mcq.question.splash.SplashViewModel

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
