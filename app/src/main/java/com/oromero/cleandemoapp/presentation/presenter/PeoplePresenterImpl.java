package com.oromero.cleandemoapp.presentation.presenter;

import com.oromero.cleandemoapp.domain.callback.PeoplePresentationCallback;
import com.oromero.cleandemoapp.domain.interactor.PeopleInteractor;
import com.oromero.cleandemoapp.presentation.model.PeoplePresentationModel;
import com.oromero.cleandemoapp.presentation.view.people.PeoplePresenterView;

import java.util.List;

/**
 * Created by oromero on 03/03/15.
 */
public class PeoplePresenterImpl implements PeoplePresenter {

    private PeoplePresenterView peoplePresenterView;
    private PeopleInteractor peopleInteractor;

    public PeoplePresenterImpl(PeoplePresenterView peoplePresenterView, PeopleInteractor peopleInteractor) {
        this.peoplePresenterView = peoplePresenterView;
        this.peopleInteractor = peopleInteractor;
    }

    @Override
    public void populateList() {
        peopleInteractor.getPeople(peoplePresentationCallback);
        peoplePresenterView.loading();
    }

    private PeoplePresentationCallback peoplePresentationCallback = new PeoplePresentationCallback() {
        @Override
        public void onGetPeopleSuccess(List<PeoplePresentationModel> peoplePresentationModels) {
            if (peoplePresentationModels != null && !peoplePresentationModels.isEmpty()) {
                peoplePresenterView.drawList(peoplePresentationModels);
            } else {
                peoplePresenterView.noData();
            }
        }

        @Override
        public void onGetPeopleFail(String error) {
            peoplePresenterView.showMessage(error);
        }
    };
}
