package quiz.mania.trivia.mcq.question.splash

import androidx.lifecycle.viewModelScope
import quiz.mania.trivia.mcq.question.MainActivity
import quiz.mania.trivia.mcq.question.common.BaseViewModel
import quiz.mania.trivia.mcq.question.ext.ClassLiveData
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

class SplashViewModel @Inject constructor(): BaseViewModel() {

    val onMoveToNext = ClassLiveData()
    private val mActivity = MainActivity::class

    init {
        viewModelScope.launch {
            delay(3500)

            onMoveToNext.postValue(mActivity)

        }
    }
}