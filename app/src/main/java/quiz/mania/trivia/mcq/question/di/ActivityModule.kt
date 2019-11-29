package quiz.mania.trivia.mcq.question.di

import quiz.mania.trivia.mcq.question.MainActivity
import quiz.mania.trivia.mcq.question.Splashy
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ActivityModule {

    @ContributesAndroidInjector
    fun provideMainActivity(): MainActivity

    @ContributesAndroidInjector
    fun provideSplashy(): Splashy
}