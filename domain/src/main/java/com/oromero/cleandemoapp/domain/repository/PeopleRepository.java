package com.oromero.cleandemoapp.domain.repository;

import com.oromero.cleandemoapp.domain.entities.Character;

import java.io.IOException;
import java.util.List;
/**
 * Created by oromero on 02/03/15.
 */
public interface PeopleRepository {

    List<Character> getPeople() throws IOException;
}