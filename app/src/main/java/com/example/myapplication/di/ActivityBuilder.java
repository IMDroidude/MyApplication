package com.example.myapplication.di;

import android.app.Activity;

import com.example.myapplication.MainActivity;
import com.example.myapplication.Splashy;
import com.example.myapplication.home.MainModelFactory;

import javax.inject.Scope;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
abstract class ActivityBuilder {

    //@Scope("")
    @ContributesAndroidInjector ///(modules = {MainModelFactory.class})
    public abstract MainActivity bindMainActivity();

    @ContributesAndroidInjector
    public abstract Splashy bindSplashy();
}

/*@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector
    abstract fun bindMainActivity (): MainActivity
    *//*@Binds
    @IntoMap
    ///@ActivityKey(MainActivity.class)
    abstract AndroidInjector.Factory<? extends Activity> bindMainActivity(MainActivityComponent.Builder builder);

    @Binds
    @IntoMap
    ///@ActivityKey(Splashy.class)
    abstract AndroidInjector.Factory<? extends Activity> bindDetailActivity(DetailActivityComponent.Builder builder);*//*

}*/
