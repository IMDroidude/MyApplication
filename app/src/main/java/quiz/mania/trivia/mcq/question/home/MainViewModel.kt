package quiz.mania.trivia.mcq.question.home

import androidx.lifecycle.viewModelScope
import quiz.mania.trivia.mcq.question.common.AlertStore
import quiz.mania.trivia.mcq.question.common.BaseViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor( private val alertStore: AlertStore)
    : BaseViewModel(){

    fun showDialog(){
        viewModelScope.launch {
            delay(4000)

            alertStore.showToast("Alert after 4 seconds.")
        }
    }
}