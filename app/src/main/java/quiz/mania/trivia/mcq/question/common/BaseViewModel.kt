package quiz.mania.trivia.mcq.question.common

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

open class BaseViewModel : ViewModel() {

    init {
        viewModelScope.launch {

        }
    }
}