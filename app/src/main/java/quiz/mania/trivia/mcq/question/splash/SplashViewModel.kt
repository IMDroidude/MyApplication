package quiz.mania.trivia.mcq.question.splash

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import quiz.mania.trivia.mcq.question.bookmvpInteractor.BooksActivity
import quiz.mania.trivia.mcq.question.common.BaseViewModel
import quiz.mania.trivia.mcq.question.ext.ClassLiveData
import javax.inject.Inject

class SplashViewModel @Inject constructor(): BaseViewModel() {

    val onMoveToNext = ClassLiveData()
    private val mActivity =  BooksActivity::class//SignInActivity::class// TagSelectionActivity::class

    init {
        viewModelScope.launch {
            delay(500)
            onMoveToNext.postValue(mActivity)

        }
    }
}