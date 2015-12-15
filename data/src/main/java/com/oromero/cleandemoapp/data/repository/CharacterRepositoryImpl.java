package com.oromero.cleandemoapp.data.repository;

import com.oromero.cleandemoapp.data.rest.UserRandomNetworkDataSource;
import com.oromero.cleandemoapp.domain.repository.CharacterRepository;

import java.io.IOException;

/**
 * Created by oromero on 02/03/15.
 */
public class CharacterRepositoryImpl implements CharacterRepository {

    private UserRandomNetworkDataSource userRandomNetworkDataSource;

    public CharacterRepositoryImpl(UserRandomNetworkDataSource userRandomNetworkDataSource) {
        this.userRandomNetworkDataSource = userRandomNetworkDataSource;
    }

    @Override
    public void getCharacter(String id) {
        //TODO implement cache
        try {
            userRandomNetworkDataSource.getCharacter(id);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
