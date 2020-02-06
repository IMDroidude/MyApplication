package quiz.mania.trivia.mcq.question.bookmvpInteractor

import com.google.firebase.firestore.FirebaseFirestore
import javax.inject.Inject

class BookApi @Inject constructor(){
    private val db = FirebaseFirestore.getInstance()

    fun fetchLatestBooks() = db.collection("questionCollection").get()

}