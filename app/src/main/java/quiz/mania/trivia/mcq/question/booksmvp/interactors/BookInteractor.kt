package quiz.mania.trivia.mcq.question.booksmvp.interactors

import quiz.mania.trivia.mcq.question.booksmvp.contract.BookDashboardContract

class BookInteractor(val iPresenter: BookDashboardContract.Presenter){

    //val bookRepository = BookRepository()

    fun fetchDataFromServer(){
        /*bookRepository.fetchBooks().addOnSuccessListener {
            val questionList = it.toObjects(QuestionBO::class.java)
        }*/
    }
}