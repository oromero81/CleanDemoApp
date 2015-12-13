package com.oromero.cleandemoapp.data.repository;

import com.oromero.cleandemoapp.data.rest.UserRandomRest;
import com.oromero.cleandemoapp.domain.callback.CharacterDataCallback;
import com.oromero.cleandemoapp.domain.repository.CharacterRepository;

import javax.inject.Inject;

/**
 * Created by oromero on 02/03/15.
 */
public class CharacterRepositoryImpl implements CharacterRepository {

    @Inject
    UserRandomRest userRandomRest;

    @Override
    public void getCharacter(String id, CharacterDataCallback characterDataCallback) {
        //TODO implement cache
        userRandomRest.getCharacter(id, characterDataCallback);
    }
}
