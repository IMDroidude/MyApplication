package quiz.mania.trivia.mcq.question.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import quiz.mania.trivia.mcq.question.booksmvp.BookDashboard
import quiz.mania.trivia.mcq.question.booksmvp.contract.BookDashboardContract
import quiz.mania.trivia.mcq.question.booksmvp.presenter.BookDashboardPresenter

@Module
abstract class BookMainModule {

    /*@Binds
    abstract fun view(mainActivity: BookDashboard): BookDashboardContract.MvpView


    companion object {
        @Provides
        fun provideAuthPresenter(view: BookDashboardContract.MvpView): BookDashboardContract.Presenter {
            return BookDashboardPresenter(view)
        }
    }*/
}