package quiz.mania.trivia.mcq.question.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import quiz.mania.trivia.mcq.question.common.AlertStore


class MainModelFactory(private val alertStore: AlertStore) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(alertStore) as T
    }
}