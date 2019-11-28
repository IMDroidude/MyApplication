package com.example.myapplication.di;

import androidx.lifecycle.ViewModel;

import com.example.myapplication.home.MainViewModel;
import com.example.myapplication.splash.SplashViewModel;

import java.util.Map;

import javax.inject.Provider;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelInjector {

    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel.class)
    public abstract ViewModel providesAccountDetailViewModel(SplashViewModel model);

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel.class)
    public abstract ViewModel providesMainViewModel(MainViewModel model);

    /*@Provides
    ViewModelFactory viewModelFactory(Map<Class<? extends ViewModel>, Provider<ViewModel>> providerMap) {
        return new ViewModelFactory(providerMap);
    }*/
}
