package quiz.mania.trivia.mcq.question.bookmvpInteractor

import kotlinx.coroutines.launch
import quiz.mania.trivia.mcq.question.booksmvp.contract.BookDashboardContract

import javax.inject.Inject

class BooksPresenter @Inject constructor(private val bookInteractorNew: BookInteractorNew): Presenter<BookDashboardContract.MvpView>(){

    fun fetchBooks(){
        launch {
            screen?.displayBooks(bookInteractorNew.getRecommendationBook())
        }
    }
}