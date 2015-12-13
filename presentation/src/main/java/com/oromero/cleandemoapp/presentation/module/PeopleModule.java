package com.oromero.cleandemoapp.presentation.module;

import com.oromero.cleandemoapp.domain.module.DomainModule;
import com.oromero.cleandemoapp.presentation.presenter.PeoplePresenter;
import com.oromero.cleandemoapp.presentation.presenter.PeoplePresenterImpl;
import com.oromero.cleandemoapp.presentation.view.people.PeopleAdapter;
import com.oromero.cleandemoapp.presentation.view.people.PeopleFragment;
import com.oromero.cleandemoapp.presentation.view.people.PeoplePresenterView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by oromero on 03/03/15.
 */
@Module(injects = PeopleFragment.class, includes = DomainModule.class, complete = false)
public class PeopleModule {

    private PeoplePresenterView presenterView;

    public PeopleModule(PeoplePresenterView presenterView) {
        this.presenterView = presenterView;
    }

    @Provides
    public PeoplePresenter providePeoplePresenter(PeopleInteractor peopleInteractor) {
        return new PeoplePresenterImpl(presenterView, peopleInteractor);
    }

    @Provides
    public PeopleAdapter providePeopleAdapter() {
        return new PeopleAdapter();
    }
}
