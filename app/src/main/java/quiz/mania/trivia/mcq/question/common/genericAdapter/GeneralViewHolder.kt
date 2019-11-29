package quiz.mania.trivia.mcq.question.common.genericAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class GeneralViewHolder<T>(parent: ViewGroup, layoutId: Int, clicklistener : (pos: Int, aView: View) -> Unit) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(layoutId, parent, false)){

    init {
        itemView.setOnClickListener{
            clicklistener.invoke(adapterPosition,itemView)
        }
    }
}