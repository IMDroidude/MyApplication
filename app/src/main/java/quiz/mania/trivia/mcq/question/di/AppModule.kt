package quiz.mania.trivia.mcq.question.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Module
import dagger.Provides
import javax.inject.Provider

@Module
class AppModule {

    /*\@Singleton
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