package quiz.mania.trivia.mcq.question.bookmvpInteractor

import android.os.Bundle
import android.widget.Toast
import dagger.android.support.DaggerAppCompatActivity
import quiz.mania.trivia.mcq.question.booksmvp.contract.BookDashboardContract
import quiz.mania.trivia.mcq.question.taglearning.QuestionBO
import javax.inject.Inject

class BooksActivity : DaggerAppCompatActivity(), BookDashboardContract.MvpView{

    @Inject
    lateinit var booksPresenter: BooksPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /*val bookApi = BookApi()
        val bookRepository = BookRepository(bookApi)
        val booksInteractorNew = BookInteractorNew(bookRepository)
        booksPresenter = BooksPresenter(booksInteractorNew)*/
        booksPresenter.attachScreen(this)

        booksPresenter.fetchBooks()
    }

    override fun onDestroy() {
        booksPresenter.detachScreen()
        super.onDestroy()
    }


    override fun displayBooks(mList: List<QuestionBO>) {
        Toast.makeText(this,"Book Displayed in BookActivity",Toast.LENGTH_LONG).show()
    }

    override fun showProgress() {
    }

    override fun hideProgress() {
    }

}