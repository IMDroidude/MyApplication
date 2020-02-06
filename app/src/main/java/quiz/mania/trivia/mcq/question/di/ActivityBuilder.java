package quiz.mania.trivia.mcq.question.di;

import quiz.mania.trivia.mcq.question.MainActivity;
import quiz.mania.trivia.mcq.question.Splashy;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import quiz.mania.trivia.mcq.question.TestListActivity;
import quiz.mania.trivia.mcq.question.bookmvpInteractor.BooksActivity;
import quiz.mania.trivia.mcq.question.booksmvp.BookDashboard;
import quiz.mania.trivia.mcq.question.fruitest.FruitActivity;
import quiz.mania.trivia.mcq.question.taglearning.TagSelectionActivity;

@Module
abstract class ActivityBuilder {

    //@Scope("")
    @ContributesAndroidInjector ///(modules = {MainModelFactory.class})
    public abstract MainActivity bindMainActivity();

    @ContributesAndroidInjector
    public abstract Splashy bindSplashy();

    @ContributesAndroidInjector
    public abstract FruitActivity bindFruitActivity();

    @ContributesAndroidInjector
    public abstract TestListActivity bindTestListActivity();

    @ContributesAndroidInjector
    public abstract TagSelectionActivity bindTagSelectionActivity();

    @ContributesAndroidInjector
    public abstract BooksActivity bindBooksActivity();

    //@ContributesAndroidInjector(modules = {BookDashboardModule.class})
    /*@ContributesAndroidInjector(modules = {BookEngineModule.class})
    //@PerActivity
    ///@ContributesAndroidInjector
    public abstract BookDashboard bindBookDashboard();*/

    @ContributesAndroidInjector(modules = {BookDashboardModule.class})
    @ActivityScope
    public abstract BookDashboard bindBookDashboard();

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
