package quiz.mania.trivia.mcq.question

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.text.Html
import android.text.SpannableString
import android.text.Spanned
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.View
import androidx.annotation.StringRes
import quiz.mania.trivia.mcq.question.common.AlertStore
import quiz.mania.trivia.mcq.question.common.BaseActivity
import quiz.mania.trivia.mcq.question.databinding.ActivityMainBinding
import quiz.mania.trivia.mcq.question.home.MainViewModel
import quiz.mania.trivia.mcq.question.testpackage.TestClass
import javax.inject.Inject
import kotlin.reflect.KClass

///@ContributesActivity
class MainActivity : BaseActivity<ActivityMainBinding,MainViewModel>() {

    @Inject lateinit var alertStore: AlertStore

    @Inject
    lateinit var testClass: TestClass

    ///private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        ///alertStore.showToast("Hello")
        testClass.getRandomValueFromCTest()

        ///viewModel = getViewModel()
        mViewModel.showDialog()


        spanTermsAndConditions()
        //viewModel = ViewModelProviders.of(this,MainModelFactory(AlertStore(this@MainActivity)))[MainViewModel::class.java]

        //viewModel.showDialog()

        //viewModel.equals("").and()
    }

    override val layoutId: Int
        get() = R.layout.activity_main

    private fun spanTermsAndConditions() {

        val termsAndConditionSpan = clickableSpan {
            openBrowser("https://transferhome.org/app/terms")
        }

        val privacyPolicySpan = clickableSpan {
            openBrowser("https://transferhome.org/app/privacy")
        }

        val html = fromHtml(R.string.terms_and_conditions)
        val termsAndConditionSpannable = SpannableString(html)

        val termsAndConditionString = html.subSequence(0, html.length)
        val termsText = getString(R.string.terms_and_cond)

        val termsStartIndex = termsAndConditionString.indexOf(termsText)
        val termsEndIndex = termsStartIndex + termsText.length


        termsAndConditionSpannable.setSpan(
            termsAndConditionSpan, termsStartIndex, termsEndIndex,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        val policyString = getString(R.string.privacy_policy)
        val policyStartIndex = termsAndConditionString.indexOf(policyString)
        val policyEndIndex = policyStartIndex + policyString.length

        termsAndConditionSpannable.setSpan(
            privacyPolicySpan, policyStartIndex, policyEndIndex,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        mBinding.terms.text = termsAndConditionSpannable
        mBinding.terms.movementMethod = LinkMovementMethod.getInstance()

    }

    fun clickableSpan(onClick: (widget: View) -> Unit): ClickableSpan {
        return object : ClickableSpan() {
            override fun onClick(widget: View) {
                onClick.invoke(widget)
            }
        }
    }

    /*

        Activity Extension are writtern below
     */
    fun Activity.openBrowser(url: String) {
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        if (browserIntent.resolveActivity(packageManager) != null) {
            openActivity(browserIntent)
        }
    }

    fun Activity.fromHtml(@StringRes stringRes: Int): Spanned {
        val textToSpan = getString(stringRes)
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            Html.fromHtml(textToSpan, Html.FROM_HTML_MODE_LEGACY)
        } else {
            @Suppress("DEPRECATION")
            Html.fromHtml(textToSpan)
        }
    }

    fun Activity.openActivityForResult(intent: Intent, reqCode: Int) {
        startActivityForResult(intent, reqCode)
    }

    fun Activity.openActivity(nextActivity: KClass<*>) {
        val intent = Intent(this, nextActivity.java)
        openActivity(intent)
    }

    fun Activity.openActivity(intent: Intent) {
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }
}
