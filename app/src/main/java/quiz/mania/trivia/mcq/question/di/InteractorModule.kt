package quiz.mania.trivia.mcq.question.di

import dagger.Module
import dagger.Provides
import quiz.mania.trivia.mcq.question.bookmvpInteractor.BookInteractorNew
import quiz.mania.trivia.mcq.question.booksmvp.repository.BookRepository
import javax.inject.Singleton

@Module
class InteractorModule {

    @Provides
    @Singleton
    fun bookInteractor(bookRepository: BookRepository) = BookInteractorNew(bookRepository)

}
