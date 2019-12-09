package quiz.mania.trivia.mcq.question.utils

import android.content.Context
import com.google.common.reflect.TypeToken
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import java.lang.reflect.Type
import javax.inject.Inject


class PrefStore @Inject constructor(context: Context) {

    private val prefs = context.getSharedPreferences("th_prefs", Context.MODE_PRIVATE)

    fun isLoggedIn(): Boolean = prefs.getBoolean(IS_LOGGED_IN, false)

    fun login() {
        prefs.edit().putBoolean(IS_LOGGED_IN, true).apply()
    }

    fun logout() {
        prefs.edit().putBoolean(IS_LOGGED_IN, false).apply()
    }

    fun selectedCountryRegion(region:String) {
        prefs.edit().putString(COUNTRY_REGION, region).apply()
    }

    fun saveToken(region:String) {
        prefs.edit().putString(AUTH_TOKEN, region).apply()
    }

    fun getToken():String? {
        return prefs.getString(AUTH_TOKEN, "")
    }

    fun getSelectedCountryRegion():String? {
        return prefs.getString(COUNTRY_REGION, "")
    }

    fun setCurrentBalance(region:String) {
        prefs.edit().putString(BALANCE, region).apply()
    }

    fun getCurrentBalance():String? {
        return prefs.getString(BALANCE, "")
    }

    fun setDeviceID(id:String) {
        prefs.edit().putString(DEVICE_ID, id).apply()
    }

    fun getDeviceID():String? {
        return prefs.getString(DEVICE_ID, "")
    }

    fun setFCMToken(token:String) {
        prefs.edit().putString(FCM_TOKEN, token).apply()
    }

    fun getFCMToken():String? {
        return prefs.getString(FCM_TOKEN, "")
    }

    fun setUserCurrencySymbol(currency:String) {
        prefs.edit().putString(USER_CURRENCY, currency).apply()
    }

    fun getUserCurrencySymbol():String? {
        return prefs.getString(USER_CURRENCY, "")
    }

    fun setUserCurrencyCode(currency:String) {
        prefs.edit().putString(USER_CURRENCY_CODE, currency).apply()
    }

    fun getUserCurrencyCode():String? {
        return prefs.getString(USER_CURRENCY_CODE, "")
    }

    fun setRelevantOffersVisibility(flag:Boolean) {
        prefs.edit().putBoolean(RELEVANT_OFFERS_CHECK, flag).apply()
    }

    fun getRelevantOffersVisibility():Boolean {
        return prefs.getBoolean(RELEVANT_OFFERS_CHECK, false)
    }

    fun setPIN(pin:String) {
        prefs.edit().putString(PIN, pin).apply()
    }

    fun getPIN():String? {
        return prefs.getString(PIN, "")
    }

    fun setisNotificationsOn(flag:Boolean) {
        prefs.edit().putBoolean(isNotificationsOn, flag).apply()
    }

    fun getisNotificationsOn():Boolean {
        return prefs.getBoolean(isNotificationsOn, false)
    }

    fun setisMailSubscriptionOn(flag:Boolean) {
        prefs.edit().putBoolean(mailSubscription, flag).apply()
    }

    fun getisMailSubscriptionOn():Boolean {
        return prefs.getBoolean(mailSubscription, false)
    }

    fun setMailSubscriptionPopUpDisplay(flag:Boolean) {
        prefs.edit().putBoolean(mailSubscription_popUp, flag).apply()
    }

    fun getisMailSubscriptionPopUpDisplay():Boolean {
        return prefs.getBoolean(mailSubscription_popUp, false)
    }

    fun setIsLoginBefore(flag:Boolean) {
        prefs.edit().putBoolean(isFirstLoginTrue, flag).apply()
    }

    fun getIsLoginBefore():Boolean {
        return prefs.getBoolean(isFirstLoginTrue, false)
    }

    fun setIsSecondTimeLogin(flag:Boolean) {
        prefs.edit().putBoolean(isSecondTimeAfterLogin, flag).apply()
    }

    fun getIsSecondTimeLogin():Boolean {
        return prefs.getBoolean(isSecondTimeAfterLogin, false)
    }


    fun setIsOnBoardingDisplayed(flag:Boolean) {
        prefs.edit().putBoolean(isOnBoardingDisplayed, flag).apply()
    }

    fun getIsOnBoardingDisplayed():Boolean {
        return prefs.getBoolean(isOnBoardingDisplayed, false)
    }

    fun setMSISDN(msisdn: String?) {
        prefs.edit().putString(MSISDN, msisdn).apply()
    }

    fun getMSISDN():String? {
        return prefs.getString(MSISDN, "")
    }

    fun save(key:String,value:String){
        prefs.edit().putString(key,value).apply()
    }

    fun read(key: String,default:String) : String{
        return prefs.getString(key,default)!!
    }

    fun <T> saveAnyTypeOfObject(key: String, value: T) {
        save(key, Gson().toJson(value))
    }

    fun <T> readAnyTypeOfObject(key: String): T {
        val json = read(key,"{}")
        return Gson().fromJson(json, object: TypeToken<T>(){}.type)
    }

    /*fun <T> saveAnyTypeOfList(key:String,dataType :T){
        val gson = GsonBuilder().create()
        val Model= gson.fromJson(body,Array<GroupModel>::class.java).toList()
    }*/


    inline fun <reified T> fromJson(json: String): T {
        return Gson().fromJson(json, object: TypeToken<T>(){}.type)
    }
    //inline fun <reified T> Gson.fromJson(json: String) = this.fromJson<T>(json, object: TypeToken<T>() {}.type)

    companion object {
        private const val IS_LOGGED_IN = "is.logged.in"
        private const val COUNTRY_REGION = "country.region"
        private const val AUTH_TOKEN = "auth.token"
        private const val BALANCE = "account.balance"
        private const val DEVICE_ID = "device.id"
        private const val FCM_TOKEN = "fcm.token"
        private const val USER_CURRENCY = "user.curency"
        private const val USER_CURRENCY_CODE = "user.curency.code"
        private const val RELEVANT_OFFERS_CHECK= "signup.checkbox.relevantOffers"
        private const val PIN = "account.pin"

        private const val isNotificationsOn = "account.isNotificationsOn"
        private const val mailSubscription = "account.mailSubscription"
        private const val mailSubscription_popUp = "account.mailSubscription.popUp"

        private const val isFirstLoginTrue = "account.isFirstLogin"

        private const val isSecondTimeAfterLogin = "account.isSecondTime"

        private const val isOnBoardingDisplayed = "auth.onboarding"
        private const val MSISDN = "account.msisdn"


    }
}