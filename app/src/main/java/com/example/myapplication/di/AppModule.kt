package com.example.myapplication.di

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.App
import com.example.myapplication.common.AlertStore
import com.example.myapplication.testpackage.TestClass
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Provider
import javax.inject.Singleton

@Module
class AppModule {

    /*@Singleton
    @Provides
    fun provideRetrofit(
        client: OkHttpClient,
        converterFactory: GsonConverterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.transferhome.co.uk")
            .client(client)
            .addConverterFactory(converterFactory)
            .build()
    }


    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        val builder = OkHttpClient.Builder()

        builder.connectTimeout(20, TimeUnit.SECONDS)
        builder.writeTimeout(20, TimeUnit.SECONDS)
        builder.readTimeout(30, TimeUnit.SECONDS)

        return builder.build()
    }

    @Singleton
    @Provides
    fun provideConverterFactory(): GsonConverterFactory = GsonConverterFactory.create(Gson())*/

    ///fun provideTestClass(testClass: TestClass) = testClass

    /*@Provides
    @Singleton
    fun provideApplication(app: App): Context = app.applicationContext*/

    //@Singleton
//    @Provides
//    fun provideAlertStore(context: Context) : AlertStore = AlertStore(context)

    @Provides
    fun provideViewModelFactories(viewModels: Map<Class<out ViewModel>,
            @JvmSuppressWildcards Provider<ViewModel>>):
            ViewModelProvider.Factory {
        return object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                val factory = viewModels[modelClass]?.get() ?: error(
                    "No factory provided against ${modelClass.name}"
                )
                @Suppress("UNCHECKED_CAST")
                return factory as T
            }
        }
    }
}