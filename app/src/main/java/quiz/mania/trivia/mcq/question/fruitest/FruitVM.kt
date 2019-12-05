package quiz.mania.trivia.mcq.question.fruitest

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import quiz.mania.trivia.mcq.question.common.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class FruitVM @Inject constructor(): BaseViewModel() {

    private val _fruits =  MutableLiveData<List<String>>()

    val fruits: LiveData<List<String>>
        get() = _fruits

    fun onButtonClicked(){

        viewModelScope.launch {
            var mFruits = withContext(Dispatchers.IO){
                val mFruitList = arrayOf("Grapes", "Apple", "Mango", "TuttiFruit", "PineApple",
                    "Pomegrante", "Apple", "Mango", "TuttiFruit", "PineApple",
                    "Pomegrante", "Apple", "Mango", "TuttiFruit", "PineApple").toList()


                return@withContext  mFruitList
            }
            _fruits.value = mFruits
        }
        /*uiScope.launch {
            var mFruits = withContext(Dispatchers.IO){
                val mFruitList = arrayOf("Grapes", "Apple", "Mango", "TuttiFruit", "PineApple",
                        "Pomegrante", "Apple", "Mango", "TuttiFruit", "PineApple",
                        "Pomegrante", "Apple", "Mango", "TuttiFruit", "PineApple").toList()


                return@withContext  mFruitList
            }
            _fruits.value = mFruits
        }*/
    }
}