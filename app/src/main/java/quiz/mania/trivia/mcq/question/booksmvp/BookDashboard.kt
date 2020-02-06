package quiz.mania.trivia.mcq.question.booksmvp

import android.os.Bundle
import android.widget.Toast
import dagger.android.support.DaggerAppCompatActivity
import quiz.mania.trivia.mcq.question.bookmvpInteractor.Book
import quiz.mania.trivia.mcq.question.booksmvp.contract.BookDashboardContract
import quiz.mania.trivia.mcq.question.taglearning.QuestionBO
import javax.inject.Inject

class BookDashboard : DaggerAppCompatActivity(),BookDashboardContract.MvpView{

    @Inject
    lateinit var presenter: BookDashboardContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.fetchedBooks()

    }

    override fun displayBooks(mList: List<QuestionBO>) {
        Toast.makeText(this,"Books Displayed",Toast.LENGTH_LONG).show()
    }

    override fun showProgress() {}
    override fun hideProgress() {}
}