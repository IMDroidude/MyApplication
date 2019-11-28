package com.example.myapplication.di

import android.content.Context
import com.example.myapplication.App
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton



@Component(
    modules = [
        AndroidInjectionModule::class, // why it is necessary to use this class for injecting purpose
        AppModule::class,
        ///AndroidSupportInjectionModule::class,
        ///ActivityModule::class,
        ActivityBuilder::class,
        ViewModelInjector::class

    ]
)
@Singleton
interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    interface Builder {

        fun addContext(@BindsInstance context: Context): Builder

        fun build(): AppComponent
    }

    ///override fun inject(instance: App?) // I should override it or not
}

/*
ThViewModelInjector::class,
ThActivityInjector::class*/
