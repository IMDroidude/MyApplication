package quiz.mania.trivia.mcq.question.common

import androidx.annotation.DrawableRes

data class WorkStatus(
    val failed: Boolean = false,
    val completed: Boolean = false,
    val inProgress: Boolean = false,

    val message: StatusMessage? = null
) {

    companion object {

        fun completed() = WorkStatus(completed = true, message = StatusMessage.from("done"))
        fun failed() = WorkStatus(failed = true, message = StatusMessage.from("Invalid number"))
        fun inProgress() = WorkStatus(inProgress = true, message = StatusMessage.from("in progress"))

    }

    /* val inProgress: Boolean
         get() = !failed && !completed*/

    val showOk: Boolean
        get() = completed || failed


    private fun wasSuccessful() = !failed && completed

    @DrawableRes
    fun getImageResource(): Int = -1
}