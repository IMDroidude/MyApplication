package quiz.mania.trivia.mcq.question

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_payment_transfer.*
import org.json.JSONObject
import quiz.mania.trivia.mcq.question.mixpanelz.AnalyticsManager

class PaymentTransferActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment_transfer)

        btn_dollar.setOnClickListener {
            val jsonObject = JSONObject();
            jsonObject.put("amout","$12")
            jsonObject.put("currency","Dollars")
            AnalyticsManager(this@PaymentTransferActivity).trackEvent("TransferAmount",jsonObject);
        }

        btn_pound.setOnClickListener {
            val jsonObject = JSONObject();
            jsonObject.put("amout","£17")
            jsonObject.put("currency","Pounds")
            AnalyticsManager(this@PaymentTransferActivity).trackEvent("TransferAmount",jsonObject);

        }

        btn_rupees.setOnClickListener {
            val jsonObject = JSONObject();
            jsonObject.put("amout","Rs.29")
            jsonObject.put("currency","Ruppees")
            AnalyticsManager(this@PaymentTransferActivity).trackEvent("TransferAmount",jsonObject);

        }
    }
}
