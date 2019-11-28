package com.example.myapplication.di

import com.example.myapplication.MainActivity
import com.example.myapplication.Splashy
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ActivityModule {

    @ContributesAndroidInjector
    fun provideMainActivity(): MainActivity

    @ContributesAndroidInjector
    fun provideSplashy(): Splashy
}