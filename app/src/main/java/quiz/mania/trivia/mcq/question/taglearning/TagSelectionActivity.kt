package quiz.mania.trivia.mcq.question.taglearning

import android.os.Bundle
import android.view.ViewGroup
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipDrawable
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_tag_selection.*
import quiz.mania.trivia.mcq.question.R
import quiz.mania.trivia.mcq.question.common.BaseActivity
import quiz.mania.trivia.mcq.question.databinding.ActivityTagSelectionBinding

class TagSelectionActivity : BaseActivity<ActivityTagSelectionBinding,TagSelectionViewModel>(){

    var mTagList:List<TagBO> = ArrayList<TagBO>()
    var categories_Selected = ArrayList<String>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Setup Category Chips
        preferenceCG.setChipSpacing(20)

        fetchQuestion("t6wdD8Crp5Q16RIbThi2");
        /*db.collection("tagCollection")
            ///.whereEqualTo("tagName",tagName)
            .get().addOnSuccessListener {

                mTagList = it.toObjects(TagBO::class.java)

                // category chips
                preferenceCG.removeAllViews()
                //categories_Selected = model.getSelectedCategories().getValue();
                //categories_Selected = model.getSelectedCategories().getValue();
                var num = 0
                for (s in mTagList) {
                    val newChip = Chip(this@TagSelectionActivity)
                    newChip.layoutParams = ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                    )
                    newChip.setChipDrawable(
                        ChipDrawable.createFromAttributes(
                            this@TagSelectionActivity, null,
                            0, R.style.Widget_MaterialComponents_Chip_Filter
                        )
                    )
                    newChip.text = s.tagName
                    newChip.id = num
                    if (categories_Selected.contains(s.tagName)) {
                        newChip.isChecked = true
                    }
                    newChip.setOnCheckedChangeListener { buttonView, isChecked ->
                        if (!categories_Selected.contains(newChip.text.toString())) {
                            categories_Selected.add(newChip.text.toString())
                        } else {
                            categories_Selected.remove(newChip.text.toString())
                        }
                        ///model.updateCategoryFireStore(categories_Selected)
                    }
                    preferenceCG.addView(newChip)
                    num++
                }
            }*/
    }

    override val layoutId: Int = R.layout.activity_tag_selection


    private fun fetchQuestion(tagID:String){
        val db = FirebaseFirestore.getInstance()
        db.collection("questionCollection")
            .whereEqualTo("tags." + tagID,true)
            .get().addOnSuccessListener {

                //var questions = it.toObjects(QuestionBO::class.java)
                ///val size = it.documents.size
                it.documents.forEach {
                    ///val mData = it.data
                    val question = it.toObject(QuestionBO::class.java)
                }
            }
    }
}