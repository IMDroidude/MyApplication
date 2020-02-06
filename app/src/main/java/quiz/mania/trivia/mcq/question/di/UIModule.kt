package quiz.mania.trivia.mcq.question.di

import dagger.Module
import dagger.Provides
import quiz.mania.trivia.mcq.question.bookmvpInteractor.BookApi
import quiz.mania.trivia.mcq.question.bookmvpInteractor.BookInteractorNew
import quiz.mania.trivia.mcq.question.bookmvpInteractor.BooksPresenter
import quiz.mania.trivia.mcq.question.booksmvp.repository.BookRepository

@Module
class UIModule{

    @Provides
    fun mainPresenter(bookInteractor: BookInteractorNew) = BooksPresenter(bookInteractor)

    @Provides
    fun bookRepository(bookApi: BookApi) = BookRepository(bookApi)

}