package quiz.mania.trivia.mcq.question.taglearning

import java.util.*
import kotlin.collections.HashMap

///@Keep
data class QuestionBO(val dateCreated: Date = Date(), val imageUrl:String = "",
                      val options:HashMap<String,Boolean> = HashMap<String,Boolean>(),
                      val questionID:String = "", val questionType:Long = 0L,
                      val tags:HashMap<String,Boolean>  = HashMap<String,Boolean>(),
                      val title: String = "", val userID:String ="", val userName:String = "")
