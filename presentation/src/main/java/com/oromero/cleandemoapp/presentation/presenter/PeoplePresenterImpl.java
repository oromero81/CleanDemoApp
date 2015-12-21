package com.oromero.cleandemoapp.presentation.presenter;

import com.oromero.cleandemoapp.domain.entities.Character;
import com.oromero.cleandemoapp.domain.interactor.PeopleInteractor;
import com.oromero.cleandemoapp.presentation.invoker.TheExecutor;
import com.oromero.cleandemoapp.presentation.mapper.PeoplePresentationMapper;
import com.oromero.cleandemoapp.presentation.model.PeoplePresentationModel;
import com.oromero.cleandemoapp.presentation.view.people.PeoplePresenterView;

import java.util.List;

import de.greenrobot.event.EventBus;

/**
 * Created by oromero on 03/03/15.
 */
public class PeoplePresenterImpl implements PeoplePresenter {

    private PeoplePresenterView peoplePresenterView;
    private PeopleInteractor peopleInteractor;
    private TheExecutor theExecutor;
    private PeoplePresentationMapper peoplePresentationMapper;

    public PeoplePresenterImpl(PeoplePresenterView peoplePresenterView, PeopleInteractor peopleInteractor, TheExecutor theExecutor, PeoplePresentationMapper peoplePresentationMapper) {
        this.peoplePresenterView = peoplePresenterView;
        this.peopleInteractor = peopleInteractor;
        this.theExecutor = theExecutor;
        this.peoplePresentationMapper = peoplePresentationMapper;
    }

    @Override
    public void populateList() {
        theExecutor.postOnBackgroundThread(peopleInteractor);
        peoplePresenterView.loading();
    }

    @Override
    public void onStart() {
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
    }

    public void onEventMainThread(List<Character> characters) {
        List<PeoplePresentationModel> peoplePresentationModels = peoplePresentationMapper.transform(characters);
        if (peoplePresentationModels != null && !peoplePresentationModels.isEmpty()) {
            peoplePresenterView.drawList(peoplePresentationModels);
        } else {
            peoplePresenterView.noData();
        }
    }

//        public void onGetPeopleFail(String error) {
//            peoplePresenterView.showMessage(error);
//        }
}