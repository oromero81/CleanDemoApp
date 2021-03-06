package com.oromero.cleandemoapp.data.repository;

import com.oromero.cleandemoapp.data.rest.UserRandomNetworkDataSource;
import com.oromero.cleandemoapp.domain.entities.Character;
import com.oromero.cleandemoapp.domain.repository.PeopleRepository;

import java.io.IOException;
import java.util.List;

/**
 * Created by oromero on 02/03/15.
 */
public class PeopleRepositoryImpl implements PeopleRepository {

    private UserRandomNetworkDataSource userRandomNetworkDataSource;

    public PeopleRepositoryImpl(UserRandomNetworkDataSource userRandomNetworkDataSource) {
        this.userRandomNetworkDataSource = userRandomNetworkDataSource;
    }

    @Override
    public List<Character> getPeople() throws IOException {
        return userRandomNetworkDataSource.getPeople();
    }
}