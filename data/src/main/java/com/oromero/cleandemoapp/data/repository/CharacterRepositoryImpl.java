package com.oromero.cleandemoapp.data.repository;

import com.oromero.cleandemoapp.data.rest.UserRandomRest;
import com.oromero.cleandemoapp.domain.repository.CharacterRepository;

/**
 * Created by oromero on 02/03/15.
 */
public class CharacterRepositoryImpl implements CharacterRepository {

    private UserRandomRest userRandomRest;

    public CharacterRepositoryImpl(UserRandomRest userRandomRest) {
        this.userRandomRest = userRandomRest;
    }

    @Override
    public void getCharacter(String id) {
        //TODO implement cache
        userRandomRest.getCharacter(id);
    }
}
