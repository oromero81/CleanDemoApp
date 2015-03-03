package com.oromero.cleandemoapp.data.repository;

import com.oromero.cleandemoapp.data.rest.UserRandomRest;
import com.oromero.cleandemoapp.domain.callback.PeopleDataCallback;
import com.oromero.cleandemoapp.domain.repository.PeopleRepository;

import javax.inject.Inject;

/**
 * Created by oromero on 02/03/15.
 */
public class PeopleRepositoryImpl implements PeopleRepository {

    @Inject
    UserRandomRest userRandomRest;

    @Override
    public void getPeople(PeopleDataCallback peopleDataCallback) {
        userRandomRest.getPeople(peopleDataCallback);
    }
}
