package quiz.mania.trivia.mcq.question.common

import android.app.Dialog
import android.content.Context
import android.view.Window
import android.widget.Toast
import quiz.mania.trivia.mcq.question.R
import javax.inject.Inject

class AlertStore @Inject constructor(context: Context) {

    var mContext: Context = context
    var dialog: Dialog? = null

    fun showToast(msg:String)
    {
        Toast.makeText(mContext , msg , Toast.LENGTH_SHORT).show()
    }

    fun noInternetDialog(flag:Boolean)
    {
        try {
            if(!flag) {
                dialog = Dialog(mContext)
                dialog!!.requestWindowFeature(Window.FEATURE_NO_TITLE)
                dialog!!.setCancelable(false)
                dialog!!.setContentView(R.layout.dialog_no_internet)
                dialog!!.show()
            }
            if(flag)
            {
                dialog?.dismiss()
            }
        } catch (e: Exception) {
        }
    }


}
