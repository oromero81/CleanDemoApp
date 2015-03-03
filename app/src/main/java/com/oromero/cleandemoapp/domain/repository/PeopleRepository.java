package com.oromero.cleandemoapp.domain.repository;

import com.oromero.cleandemoapp.domain.callback.PeopleDataCallback;

/**
 * Created by oromero on 02/03/15.
 */
public interface PeopleRepository {

    public void getPeople(PeopleDataCallback peopleDataCallback);

}
