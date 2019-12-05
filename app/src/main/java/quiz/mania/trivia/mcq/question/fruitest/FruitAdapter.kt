package quiz.mania.trivia.mcq.question.fruitest

import android.view.ViewGroup
import quiz.mania.trivia.mcq.question.R

class FruitAdapter(items: List<String>) : BaseAdapter<String>(items) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<String> {
        return FruitVH(parent, R.layout.item_fruit)
    }
}