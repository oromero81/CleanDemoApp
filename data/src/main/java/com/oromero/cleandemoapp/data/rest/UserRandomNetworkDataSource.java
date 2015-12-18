package com.oromero.cleandemoapp.data.rest;

import com.oromero.cleandemoapp.domain.entities.Character;

import java.io.IOException;
import java.util.List;

/**
 * Created by oromero on 02/03/15.
 */
public interface UserRandomNetworkDataSource {

    List<Character> getPeople() throws IOException;

    Character getCharacter(String id) throws IOException;
}