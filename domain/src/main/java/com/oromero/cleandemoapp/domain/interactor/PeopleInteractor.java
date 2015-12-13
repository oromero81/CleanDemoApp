package com.oromero.cleandemoapp.domain.interactor;

import com.oromero.cleandemoapp.domain.callback.PeopleDataCallback;
import com.oromero.cleandemoapp.domain.entities.Character;
import com.oromero.cleandemoapp.domain.mapper.PeoplePresentationMapper;
import com.oromero.cleandemoapp.domain.repository.PeopleRepository;

import java.util.List;

/**
 * Created by oromero on 03/03/15.
 */
public class PeopleInteractor implements Interactor {

    private PeopleRepository peopleRepository;
    private PeoplePresentationMapper peoplePresentationMapper;

    public PeopleInteractor(PeopleRepository peopleRepository, PeoplePresentationMapper peoplePresentationMapper) {
        this.peopleRepository = peopleRepository;
        this.peoplePresentationMapper = peoplePresentationMapper;
    }

    private PeopleDataCallback peopleDataCallback = new PeopleDataCallback() {
        @Override
        public void onGetPeopleSuccess(List<Character> characters) {
//            peoplePresentationCallback.onGetPeopleSuccess(peoplePresentationMapper.transform(characters));
        }

        @Override
        public void onGetPeopleFailed(String error) {
//            peoplePresentationCallback.onGetPeopleFail(error);
        }
    };

    @Override
    public void run() {
        peopleRepository.getPeople(peopleDataCallback);
    }
}