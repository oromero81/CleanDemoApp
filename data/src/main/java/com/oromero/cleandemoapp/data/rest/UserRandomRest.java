package com.oromero.cleandemoapp.data.rest;

import com.oromero.cleandemoapp.domain.callback.CharacterDataCallback;
import com.oromero.cleandemoapp.domain.callback.PeopleDataCallback;

/**
 * Created by oromero on 02/03/15.
 */
public interface UserRandomRest {

    public void getPeople(PeopleDataCallback peopleDataCallback);

    public void getCharacter(String id, CharacterDataCallback characterDataCallback);
}
