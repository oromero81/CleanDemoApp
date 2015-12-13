package com.oromero.cleandemoapp.data.repository;

import com.oromero.cleandemoapp.data.rest.UserRandomRest;
import com.oromero.cleandemoapp.domain.repository.PeopleRepository;

/**
 * Created by oromero on 02/03/15.
 */
public class PeopleRepositoryImpl implements PeopleRepository {

    private UserRandomRest userRandomRest;

    public PeopleRepositoryImpl(UserRandomRest userRandomRest) {
        this.userRandomRest = userRandomRest;
    }

    @Override
    public void getPeople() {
        userRandomRest.getPeople();
    }
}