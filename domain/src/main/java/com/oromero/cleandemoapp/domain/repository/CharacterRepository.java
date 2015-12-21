package com.oromero.cleandemoapp.domain.repository;

import com.oromero.cleandemoapp.domain.entities.Character;

import java.io.IOException;
/**
 * Created by oromero on 02/03/15.
 */
public interface CharacterRepository {
    Character getCharacter(String id) throws IOException;
}