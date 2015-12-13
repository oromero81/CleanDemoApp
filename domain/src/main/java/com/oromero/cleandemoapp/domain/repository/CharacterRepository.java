package com.oromero.cleandemoapp.domain.repository;

import com.oromero.cleandemoapp.domain.callback.CharacterDataCallback;

/**
 * Created by oromero on 02/03/15.
 */
public interface CharacterRepository {

    public void getCharacter(String id, CharacterDataCallback characterDataCallback);
}
