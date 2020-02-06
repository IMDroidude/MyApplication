package quiz.mania.trivia.mcq.question.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import quiz.mania.trivia.mcq.question.booksmvp.BookDashboard
import quiz.mania.trivia.mcq.question.booksmvp.contract.BookDashboardContract
import quiz.mania.trivia.mcq.question.booksmvp.interactors.BookInteractor
import quiz.mania.trivia.mcq.question.booksmvp.presenter.BookDashboardPresenter


@Module
class BookDashboardModule {

 @Provides
 @ActivityScope
 fun provideBookPresenter(view: BookDashboard): BookDashboardContract.Presenter = BookDashboardPresenter(view)

 /*@Provides
 @ActivityScope
 fun Provides(bookPresenter:BookDashboardPresenter) = BookInteractor(bookPresenter)*/
}

 /*@Module
 abstract class BookDashboardModule() {


    *//*@Provides
    @ActivityScope
    fun providesCategoryView(): BookDashboardContract.MvpView {
        return this.mvpView
    }

    @Provides
    @ActivityScope
    fun provideBookPresenter(): BookDashboardPresenter {
        return BookDashboardPresenter(mvpView)
    }*//*

    *//*@Binds
    @ActivityScope
    abstract fun presenter(presenter: BookDashboardPresenter): BookDashboardContract.Presenter

    @Provides
    open fun providesStoryView(): BookDashboardContract.MvpView? {
        val anyType:BookDashboardContract.MvpView = BookDashboard()
        return anyType
    }*//*

    *//*@Provides
    fun getSomethod(): BookDashboardContract.MvpView{
        return BookDashboardContract.MvpView;
    }*//*
   *//* @Provides
    fun providePresenter(): BookDashboardContract.Presenter {
        return BookDashboardPresenter()
    }*//*
    *//*@ContributesAndroidInjector(modules = [ProfileFragmentModule::class])
    @FragmentScope
    internal abstract fun ProfileFragment(): ProfileFragment


    @ContributesAndroidInjector(modules = [QuizFragmentModule::class])
    @FragmentScope
    internal abstract fun QuizFragment(): QuizFragment

    @ContributesAndroidInjector(modules = [HighScoreFragmentModule::class])
    @FragmentScope
    internal abstract fun HighScoreFragment(): HighScoreFragment*//*
}*/