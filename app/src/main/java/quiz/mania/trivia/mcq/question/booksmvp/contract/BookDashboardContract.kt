package quiz.mania.trivia.mcq.question.booksmvp.contract

import quiz.mania.trivia.mcq.question.bookmvpInteractor.Book
import quiz.mania.trivia.mcq.question.taglearning.QuestionBO

interface BookDashboardContract {

    interface MvpView{
        fun displayBooks(mList:List<QuestionBO>)
        fun showProgress()
        fun hideProgress()
    }

    interface Presenter{
        fun fetchedBooks()
    }
}