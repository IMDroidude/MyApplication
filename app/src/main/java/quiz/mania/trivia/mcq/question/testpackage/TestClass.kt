package quiz.mania.trivia.mcq.question.testpackage

import android.content.Context
import quiz.mania.trivia.mcq.question.common.AlertStore
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TestClass @Inject constructor(private val context:Context) {
    fun getRandomValueFromCTest(){
        val testOperator = AlertStore(context)
        testOperator.showToast("Any Dummy Toast")
    }
}
