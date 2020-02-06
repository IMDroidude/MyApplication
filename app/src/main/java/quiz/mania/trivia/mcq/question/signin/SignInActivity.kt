package quiz.mania.trivia.mcq.question.signin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_sign_in.*
import quiz.mania.trivia.mcq.question.MainActivity
import quiz.mania.trivia.mcq.question.R

class SignInActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        loginBtn.setOnClickListener {
            val email = emailEt.text.toString()
            val password = passwordEt.text.toString()

            if(email.equals("email") && password.equals("pass")){
                startActivity(Intent(this,MainActivity::class.java))
                finish()
            } else{
                Toast.makeText(this,"Wrong password",Toast.LENGTH_LONG).show()
            }
        }
    }
}
