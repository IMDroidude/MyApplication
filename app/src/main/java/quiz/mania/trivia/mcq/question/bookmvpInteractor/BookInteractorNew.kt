package quiz.mania.trivia.mcq.question.bookmvpInteractor

import quiz.mania.trivia.mcq.question.booksmvp.repository.BookRepository
import quiz.mania.trivia.mcq.question.taglearning.QuestionBO
import javax.inject.Inject

class BookInteractorNew @Inject constructor(private val bookRepository: BookRepository){

    suspend fun getRecommendationBook(): List<QuestionBO> {
        return bookRepository.getPopularBooks()
    }
}