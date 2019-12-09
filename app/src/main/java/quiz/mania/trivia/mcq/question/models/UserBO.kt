package quiz.mania.trivia.mcq.question.models

import java.util.*

data class UserBO(val dateCreated: Date = Date(), val email:String = "",
                  val favouriteTag:HashMap<String,String> = HashMap(),
                  val phoneNumber:String = "", val token: String = "",
                  val userID:String = "", val userName:String = "")