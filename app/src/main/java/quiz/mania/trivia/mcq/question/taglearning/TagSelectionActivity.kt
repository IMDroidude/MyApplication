package quiz.mania.trivia.mcq.question.taglearning

import android.os.Bundle
import android.util.Log
import com.google.common.reflect.TypeToken
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_tag_selection.*
import quiz.mania.trivia.mcq.question.R
import quiz.mania.trivia.mcq.question.common.BaseActivity
import quiz.mania.trivia.mcq.question.databinding.ActivityTagSelectionBinding
import quiz.mania.trivia.mcq.question.models.UserBO
import quiz.mania.trivia.mcq.question.utils.PrefStore


class TagSelectionActivity : BaseActivity<ActivityTagSelectionBinding,TagSelectionViewModel>(){

    var mTagList:List<TagBO> = ArrayList<TagBO>()
    var categories_Selected = ArrayList<String>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Setup Category Chips
        preferenceCG.setChipSpacing(20)

        ///fetchQuestion("t6wdD8Crp5Q16RIbThi2","TtEDg0PcZPBUIvMEnp7D");

        fetchUserSelectedTags("Kq5wYN7kkE8mZxochUte")

        ///fetchQuestionAfter("lFynl4dEwRdPBP7YaVBx")
        //fetchQuestion("t6wdD8Crp5Q16RIbThi2");

        ///fetchQuestionPagination()

        //fetchCollectionAfterDocumentID(5)
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

    private fun fetchQuestionAfter(questionID: String) {
        val db = FirebaseFirestore.getInstance()
        val collectionReference = db.collection("questionCollection")

        var query:Query = collectionReference.orderBy("questionID", Query.Direction.DESCENDING)
            .whereLessThanOrEqualTo("questionID",questionID).limit(5)

        query.get().addOnSuccessListener {
            var questions = it.toObjects(QuestionBO::class.java) // create a list above and set it to chipGroup or recyclerView
            val size = questions.size
        }

    }

    override val layoutId: Int = R.layout.activity_tag_selection


    /*private fun fetchQuestion(tagID:String){
        val db = FirebaseFirestore.getInstance()
        db.collection("questionCollection")
            .whereEqualTo("tags." + tagID,true)
            .get().addOnSuccessListener {

                //var questions = it.toObjects(QuestionBO::class.java)
                val size = it.documents.size
                it.documents.forEach {
                    ///val mData = it.data
                    val question = it.toObject(QuestionBO::class.java)
                    val title = question?.title
                }
            }
    }*/

    private fun fetchQuestionPagination(){
        val db = FirebaseFirestore.getInstance()
        val collectionReference = db.collection("questionCollection")

        var query:Query = collectionReference.orderBy("questionID",
            Query.Direction.DESCENDING).limit(2)
        query.get().addOnCompleteListener {
            if(it.isSuccessful){
                it.result.let {
                    it?.let {
                        val lastVisibleitem = it.documents.get(it.size() -1 )
                        lastVisibleitem.data.let {

                        }

                        /*val nextQuery: Query = collectionReference.orderBy(
                            "questionID",
                            Query.Direction.DESCENDING
                        ).startAfter(lastVisibleitem).limit(2)

                        nextQuery.get().addOnCompleteListener{
                            var questions = it.result?.documents?.size


                        }*/
                    }
                }
            }
        }
    }

    private fun fetchCollectionAfterDocumentID(limit :Long){

        val db = FirebaseFirestore.getInstance()
        var query:Query = db.collection("questionCollection")
            .startAfter("cDxXGLHlP56xnAp4RmE5")
            .orderBy("questionID", Query.Direction.DESCENDING)
        .limit(limit)

        query.get().addOnSuccessListener {
            var questions = it.toObjects(QuestionBO::class.java) // create a list above and set it to chipGroup or recyclerView
            questions.size
        }
    }


    private fun fetchUserSelectedTags(userID:String){
        val db = FirebaseFirestore.getInstance()
        val collectionReference = db.collection("UserCollection")
        collectionReference.document(userID).get().addOnCompleteListener {

            if(it.isSuccessful){
                val querySnapshot = it.result
                val userBO = querySnapshot?.toObject(UserBO::class.java)

                PrefStore(this@TagSelectionActivity).saveAnyTypeOfObject("userBOkey",userBO);

                val newUser = PrefStore(this@TagSelectionActivity).readAnyTypeOfObject<UserBO>("userBOkey")

                userBO?.favouriteTag?.forEach{
                    Log.d("keyValue","${it.key}  -> ${it.value}")
                }
                ///val tag = it.getResult()?.get("favouriteTag")
            }

            val callSecondMethod = true;
        }
    }



    private fun fetchQuestion(vararg tagID:String){
        val db = FirebaseFirestore.getInstance()
        val collectionReference = db.collection("questionCollection")

        var query:Query = collectionReference.orderBy("questionID",
            Query.Direction.DESCENDING).limit(10)

        for (item in tagID)
            query = collectionReference.whereEqualTo("tags." + item,true)

        query.get().addOnSuccessListener {
            //var size = it.documents.size

            var questions = it.toObjects(QuestionBO::class.java) // create a list above and set it to chipGroup or recyclerView
            /*it.documents.forEach {
                ///val mData = it.data
                val question = it.toObject(QuestionBO::class.java)
            }*/

        }
        /*db.collection("questionCollection")
            .whereEqualTo("tags." + tagID,true)
            .whereEqualTo("tags.TtEDg0PcZPBUIvMEnp7D",true)
            .get().addOnSuccessListener {

                //var questions = it.toObjects(QuestionBO::class.java)
                ///val size = it.documents.size
                it.documents.forEach {
                    ///val mData = it.data
                    val question = it.toObject(QuestionBO::class.java)
                }
            }*/
    }

    inline fun <reified T> Gson.fromJson(json: String) = this.fromJson<T>(json, object: TypeToken<T>() {}.type)

}