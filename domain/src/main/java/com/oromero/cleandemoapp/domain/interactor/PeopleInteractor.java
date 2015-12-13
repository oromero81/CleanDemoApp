package com.oromero.cleandemoapp.domain.interactor;


import com.oromero.cleandemoapp.domain.repository.PeopleRepository;

/**
 * Created by oromero on 03/03/15.
 */
public class PeopleInteractor implements Interactor {

    private PeopleRepository peopleRepository;

    public PeopleInteractor(PeopleRepository peopleRepository) {
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
        peopleRepository.getPeople();
    }
}