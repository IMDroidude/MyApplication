package quiz.mania.trivia.mcq.question.bookmvpInteractor

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

abstract class Presenter<S> : CoroutineScope {

    protected var screen: S? = null

    var job: Job = Job()

    override val coroutineContext: CoroutineContext = Contexts.UI + job

    open fun attachScreen(screen: S) {
        this.screen = screen
    }

    open fun detachScreen() {
        this.screen = null
        job.cancel()
    }

}