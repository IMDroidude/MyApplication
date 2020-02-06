package quiz.mania.trivia.mcq.question.booksmvp.presenter

import quiz.mania.trivia.mcq.question.booksmvp.contract.BookDashboardContract
import quiz.mania.trivia.mcq.question.booksmvp.interactors.BookInteractor
import javax.inject.Inject

///class BookDashboardPresenter @Inject constructor() : BookDashboardContract.Presenter{
class BookDashboardPresenter @Inject constructor(val viewContract:BookDashboardContract.MvpView) : BookDashboardContract.Presenter{

    val bookInteractor = BookInteractor(this)

    override fun fetchedBooks() {
        bookInteractor.fetchDataFromServer()
        viewContract.displayBooks(ArrayList())
    }
}