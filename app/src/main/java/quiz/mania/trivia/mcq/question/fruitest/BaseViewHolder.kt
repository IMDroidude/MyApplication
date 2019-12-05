package quiz.mania.trivia.mcq.question.fruitest

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<T>(parent: ViewGroup, layoutId: Int) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(layoutId, parent, false)) {

    abstract fun bindData(data:T)
}