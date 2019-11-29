package quiz.mania.trivia.mcq.question.ext

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import quiz.mania.trivia.mcq.question.common.WorkStatus
import kotlin.reflect.KClass


typealias ClassLiveData = MutableLiveData<KClass<*>>

typealias WorkLiveData = MutableLiveData<WorkStatus>

typealias IntLiveData = MutableLiveData<Int>


fun <T> LiveData<T>.listen(owner: LifecycleOwner, cb: (data: T) -> Unit) {
    observe(owner, Observer {
        cb.invoke(it)
    })
}