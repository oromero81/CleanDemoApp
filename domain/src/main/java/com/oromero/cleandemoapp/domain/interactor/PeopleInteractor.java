package com.oromero.cleandemoapp.domain.interactor;


import com.oromero.cleandemoapp.domain.repository.PeopleRepository;

import java.io.IOException;

/**
 * Created by oromero on 03/03/15.
 */
public class PeopleInteractor implements Interactor {

    private Buzzer buzzer;
    private PeopleRepository peopleRepository;

    public PeopleInteractor(Buzzer buzzer, PeopleRepository peopleRepository) {
        this.buzzer = buzzer;
        this.peopleRepository = peopleRepository;
    }

    //    private PeopleDataCallback peopleDataCallback = new PeopleDataCallback() {
//        @Override
//        public void onGetPeopleSuccess(List<Character> characters) {
////            peoplePresentationCallback.onGetPeopleSuccess(peoplePresentationMapper.transform(characters));
//        }
//
//        @Override
//        public void onGetPeopleFailed(String error) {
////            peoplePresentationCallback.onGetPeopleFail(error);
//        }
//    };

    @Override
    public void run() {
        try {
            buzzer.broadcastEvent(peopleRepository.getPeople());
        } catch (IOException e) {
//            buzzer.broadcastEvent(error);
        }
    }
}