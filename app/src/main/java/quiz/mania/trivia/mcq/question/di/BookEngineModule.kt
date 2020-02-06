package quiz.mania.trivia.mcq.question.di

import dagger.Module
import dagger.Provides
import quiz.mania.trivia.mcq.question.booksmvp.BookDashboard
import quiz.mania.trivia.mcq.question.booksmvp.contract.BookDashboardContract
import quiz.mania.trivia.mcq.question.booksmvp.presenter.BookDashboardPresenter

/*
@Module
class BookEngineModule(val mvpView: BookDashboardContract.MvpView){

    @Provides
    fun providePresenter():BookDashboardContract.Presenter{
        return BookDashboardPresenter(mvpView)
    }

    @Provides
    fun providesMvpView(bookDashboard: BookDashboard):BookDashboardContract.MvpView{
        return bookDashboard
    }
}*/
