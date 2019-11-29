package quiz.mania.trivia.mcq.question.di;

import androidx.lifecycle.ViewModel;

import quiz.mania.trivia.mcq.question.home.MainViewModel;
import quiz.mania.trivia.mcq.question.splash.SplashViewModel;

import dagger.Binds;
import dagger.Module;
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
