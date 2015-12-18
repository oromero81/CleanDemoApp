package com.oromero.cleandemoapp.data.rest;


import com.oromero.cleandemoapp.data.mapper.UserDTOMapper;
import com.oromero.cleandemoapp.data.model.ResponseDTO;
import com.oromero.cleandemoapp.domain.entities.Character;

import java.io.IOException;
import java.util.List;

import retrofit.Call;
import retrofit.Response;

/**
 * Created by oromero on 02/03/15.
 */
public class UserRandomNetworkDataSourceImpl implements UserRandomNetworkDataSource {

    private static final int RESULTS = 100;

    private RandomUserApi api;
    private UserDTOMapper userDTOMapper;

    public UserRandomNetworkDataSourceImpl(RandomUserApi api, UserDTOMapper userDTOMapper) {
        this.api = api;
        this.userDTOMapper = userDTOMapper;
    }

    @Override
    public List<Character> getPeople() throws IOException {
        Call<ResponseDTO> call = api.getPeople(RESULTS);
        Response<ResponseDTO> response = call.execute();

        return userDTOMapper.transform(response.body().getResults());
    }

    @Override
    public Character getCharacter(String id) throws IOException {
        Call<ResponseDTO> call = api.getCharacter(id);
        Response<ResponseDTO> response = call.execute();

        return userDTOMapper.transform(response.body().getResults().get(0));
    }
}