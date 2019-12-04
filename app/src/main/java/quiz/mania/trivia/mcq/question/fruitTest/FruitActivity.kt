package quiz.mania.trivia.mcq.question.fruitTest

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import quiz.mania.trivia.mcq.question.common.genericAdapter.GenericAdapter
import quiz.mania.trivia.mcq.question.common.genericAdapter.OnAdapterBind
import kotlinx.android.synthetic.main.activity_fruit.*
import kotlinx.android.synthetic.main.item_fruit.view.*
import kotlinx.coroutines.*
import org.json.JSONObject
import quiz.mania.trivia.mcq.question.R
import quiz.mania.trivia.mcq.question.mixpanelz.AnalyticsManager

class FruitActivity : AppCompatActivity() {

    ///var fruits:List<String> = arrayOf("Grapes","Apple","Mango","TuttiFruit","PineApple").toList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fruit)


        AnalyticsManager(this@FruitActivity).trackEvent("Visited FruitList")

        /*GlobalScope.launch { // launch a new coroutine in background and continue
            delay(1000L)
            println("World!")
        }
        println("Hello,") // main thread continues here immediately
        runBlocking {     // but this expression blocks the main thread
            delay(5000L)  // ... while we delay for 2 seconds to keep JVM alive
        }
        println("After Blocking,") // main thread continues here immediately*/


        /*runBlocking {
            launch {
                delay(200L)
                println("Task from runBlocking")
            }

            coroutineScope { // Creates a coroutine scope
                launch {
                    delay(500L)
                    println("Task from nested launch")
                }

                delay(100L)
                println("Task from coroutine scope") // This line will be printed before the nested launch
            }

            println("Coroutine scope is over") // This line is not printed until the nested launch completes
        }
*/
        /*GlobalScope.launch(Dispatchers.Main) {
            println("Called before dealy in launch")
            delay(1000L)
            println("Called after dealy in launch")
        }

        println("Called after Co routine Scope finished")*/

        recyclerView.apply {
            hasFixedSize()
            addItemDecoration(DividerItemDecoration(this@FruitActivity, DividerItemDecoration.VERTICAL))
        }

        val fruitVM = ViewModelProviders.of(this).get(FruitVM::class.java)
        fruitVM.fruits.observe(this , Observer {


            /*val carList = listOf<Car>(Car("Moras", Color.BLACK),Car("honda", Color.BLUE),Car("audi", Color.BLACK),
                    Car("Moras", Color.BLACK),Car("honda", Color.BLUE),Car("audi", Color.BLACK),
                    Car("Moras", Color.BLACK),Car("honda", Color.BLUE),Car("audi", Color.BLACK))
            recyclerView.adapter = GenericAdapter<Car>( carList, object : OnAdapterBind<Car> {

                override fun onBindData(itemView: View?, data: Car?) {
                    itemView?.fruitTv?.text = data?.name
                }

                override fun setLayoutId(position: Int, obj: Car?): Int = R.layout.item_fruit

                override fun onItemClicked(position: Int, mView: View?) {
                    Toast.makeText(this@FruitActivity,"Clicked -> " + position,Toast.LENGTH_LONG).show()
                }
            })*/

            recyclerView.adapter = GenericAdapter<String>(it,object : OnAdapterBind<String> {
                override fun onBindData(itemView: View?, data: String?) {
                    itemView?.fruitTv?.text = data
                }

                override fun setLayoutId(position: Int, obj: String?): Int {
                    return R.layout.item_fruit
                }

                override fun onItemClicked(position: Int, mView: View?) {
                    Toast.makeText(this@FruitActivity,"Clicked " + it.get(position), Toast.LENGTH_LONG).show()
                    val jsonObject = JSONObject()
                    jsonObject.put("fruitName",it.get(position))
                    AnalyticsManager(this@FruitActivity).trackEvent("Selected Fruit",jsonObject)
                }
            })

            /*val list= listOf<Any>(Car("audi", Color.BLACK),Bus("Eicher",Color.BLUE),Bus("Benz",Color.BLACK),Car("Suzuki",Color.WHITE)
            ,Car("Moras", Color.BLACK),Car("honda", Color.BLUE),Car("audi", Color.BLACK))


            recyclerView.adapter = GenericAdapter<Any>( list, object : OnAdapterBind<Any> {

                override fun onBindData(itemView: View?, data: Any?) {
                    when(data){
                        is Car -> itemView?.fruitTv?.text = "Car Rasha"
                        is Bus -> itemView?.vegetableTv?.text = "Bus Bus"
                    }
                }

                override fun setLayoutId(position: Int, obj: Any?): Int {
                    when(obj){
                        is Car -> R.layout.item_fruit
                        is Bus -> R.layout.item_vegetable
                    }
                    return R.layout.item_fruit
                }

                override fun onItemClicked(position: Int, mView: View?) {

                }
            })*/

        })


        fruitVM.onButtonClicked()
    }

    suspend fun fetchFruitList(): List<String> {
        return arrayOf("Grapes", "Apple", "Mango", "TuttiFruit", "PineApple",
            "Pomegrante", "Apple", "Mango", "TuttiFruit", "PineApple",
            "Pomegrante", "Apple", "Mango", "TuttiFruit", "PineApple").toList()
    }

    fun firstFunction(){
        GlobalScope.launch(Dispatchers.IO) {
            var fruits = fetchFruitList()

            withContext(Dispatchers.Main) {
                ///recyclerView.adapter = FruitAdapter(fruits)
            }
        }
    }

    fun secondFunction(){
        GlobalScope.launch(Dispatchers.Main) {
            val fruits: List<String> = async(Dispatchers.IO) {
                arrayOf("Grapes", "Apple", "Mango", "TuttiFruit", "PineApple",
                    "Pomegrante", "Apple", "Mango", "TuttiFruit", "PineApple",
                    "Pomegrante", "Apple", "Mango", "TuttiFruit", "PineApple").toList()
            }.await()
            ///recyclerView.adapter = FruitAdapter(fruits)
        }
    }

    fun thirdFunction(){
        GlobalScope.launch (Dispatchers.Main){
            var fruits = withContext(Dispatchers.IO){
                val someData = arrayOf("Grapes", "Apple", "Mango", "TuttiFruit", "PineApple",
                    "Pomegrante", "Apple", "Mango", "TuttiFruit", "PineApple",
                    "Pomegrante", "Apple", "Mango", "TuttiFruit", "PineApple").toList()
                return@withContext  someData
            }
            if(fruits.isNotEmpty()){
                ///recyclerView.adapter = FruitAdapter(fruits)
            }
        }
    }

    fun <T : RecyclerView.ViewHolder> T.listen(event: (position: Int, type: Int) -> Unit): T {
        itemView.setOnClickListener {
            event.invoke(getAdapterPosition(), getItemViewType())
        }
        return this
    }

    class Car(var name: String, var color: Int)

    class Bus(var name: String, var color: Int)
}