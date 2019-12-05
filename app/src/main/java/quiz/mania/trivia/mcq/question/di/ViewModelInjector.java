package quiz.mania.trivia.mcq.question.di;

import androidx.lifecycle.ViewModel;

import quiz.mania.trivia.mcq.question.fruitest.FruitVM;
import quiz.mania.trivia.mcq.question.home.MainViewModel;
import quiz.mania.trivia.mcq.question.splash.SplashViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import quiz.mania.trivia.mcq.question.taglearning.TagSelectionViewModel;
import quiz.mania.trivia.mcq.question.testlit.TestListModel;

@Module
public abstract class ViewModelInjector {

    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel.class)
    public abstract ViewModel providesSplashViewModel(SplashViewModel model);

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel.class)
    public abstract ViewModel providesMainViewModel(MainViewModel model);

    @Binds
    @IntoMap
    @ViewModelKey(TestListModel.class)
    public abstract ViewModel providesTestViewModel(TestListModel model);

    @Binds
    @IntoMap
    @ViewModelKey(FruitVM.class)
    public abstract ViewModel providesFruitVM(FruitVM model);

    @Binds
    @IntoMap
    @ViewModelKey(TagSelectionViewModel.class)
    public abstract ViewModel providesTagSelectionViewModel(TagSelectionViewModel model);

    /*@Provides
    ViewModelFactory viewModelFactory(Map<Class<? extends ViewModel>, Provider<ViewModel>> providerMap) {
        return new ViewModelFactory(providerMap);
    }*/
}
