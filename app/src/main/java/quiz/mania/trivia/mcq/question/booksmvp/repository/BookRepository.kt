package quiz.mania.trivia.mcq.question.booksmvp.repository

import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import quiz.mania.trivia.mcq.question.bookmvpInteractor.BookApi
import quiz.mania.trivia.mcq.question.bookmvpInteractor.Contexts
import quiz.mania.trivia.mcq.question.taglearning.QuestionBO
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BookRepository @Inject constructor(val bookApi: BookApi){

    suspend fun getPopularBooks(): List<QuestionBO> = withContext(Contexts.NETWORK) {
        //val task =  bookApi.fetchLatestBooks().asDeferred()
        val task =  bookApi.fetchLatestBooks().await()
        return@withContext task.toObjects(QuestionBO::class.java)
    }

/*val response = bookApi.getPopularBooks().execute()
        if (response.isSuccessful) {
            return@withContext response.body()!!
        } else {
            when (response.code()) {
                401 -> throw UnauthorizedException("Unauthorized")
                403 -> throw ForbiddenException("Forbidden")
                404 -> throw NotFoundException("Not found")
                else -> throw Exception(response.message())
            }
        */
}