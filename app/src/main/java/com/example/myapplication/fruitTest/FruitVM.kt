package com.example.myapplication.fruitTest

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.myapplication.common.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FruitVM : BaseViewModel() {

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