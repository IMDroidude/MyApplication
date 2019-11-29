package quiz.mania.trivia.mcq.question

import quiz.mania.trivia.mcq.question.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class App : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().addContext(this).build()
    }
}