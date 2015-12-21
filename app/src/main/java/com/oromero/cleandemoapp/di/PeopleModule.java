package com.oromero.cleandemoapp.di;

import com.oromero.cleandemoapp.domain.interactor.PeopleInteractor;
import com.oromero.cleandemoapp.presentation.invoker.TheExecutor;
import com.oromero.cleandemoapp.presentation.mapper.PeoplePresentationMapper;
import com.oromero.cleandemoapp.presentation.presenter.PeoplePresenter;
import com.oromero.cleandemoapp.presentation.presenter.PeoplePresenterImpl;
import com.oromero.cleandemoapp.presentation.view.people.PeoplePresenterView;
import com.oromero.cleandemoapp.ui.PeopleAdapter;
import com.oromero.cleandemoapp.ui.PeopleFragment;

import dagger.Module;
import dagger.Provides;

/**
 * Created by oromero on 03/03/15.
 */
@Module(
        addsTo = AppModule.class,
        library = true,
        injects = PeopleFragment.class
)
public class PeopleModule {

    private PeoplePresenterView presenterView;

    public PeopleModule(PeoplePresenterView presenterView) {
        this.presenterView = presenterView;
    }

    @Provides
    public PeoplePresenter providePeoplePresenter(PeopleInteractor peopleInteractor, TheExecutor theExecutor, PeoplePresentationMapper peoplePresentationMapper) {
        return new PeoplePresenterImpl(presenterView, peopleInteractor, theExecutor, peoplePresentationMapper);
    }

    @Provides
    public PeopleAdapter providePeopleAdapter() {
        return new PeopleAdapter();
    }
}