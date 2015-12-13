package com.oromero.cleandemoapp.domain.interactor;

import com.oromero.cleandemoapp.domain.entities.CharacterDataModel;
import com.oromero.cleandemoapp.domain.callback.PeopleDataCallback;
import com.oromero.cleandemoapp.domain.callback.PeoplePresentationCallback;
import com.oromero.cleandemoapp.domain.mapper.PeoplePresentationMapper;
import com.oromero.cleandemoapp.domain.repository.PeopleRepository;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by oromero on 03/03/15.
 */
public class PeopleInteractorImpl implements PeopleInteractor {

    @Inject
    PeopleRepository peopleRepository;
    @Inject
    PeoplePresentationMapper peoplePresentationMapper;

    PeoplePresentationCallback peoplePresentationCallback;

    @Override
    public void getPeople(PeoplePresentationCallback peoplePresentationCallback) {
        this.peoplePresentationCallback = peoplePresentationCallback;
        peopleRepository.getPeople(peopleDataCallback);
    }

    private PeopleDataCallback peopleDataCallback = new PeopleDataCallback() {
        @Override
        public void onGetPeopleSuccess(List<CharacterDataModel> characterDataModels) {
            peoplePresentationCallback.onGetPeopleSuccess(peoplePresentationMapper.transform(characterDataModels));
        }

        @Override
        public void onGetPeopleFailed(String error) {
            peoplePresentationCallback.onGetPeopleFail(error);
        }
    };
}
