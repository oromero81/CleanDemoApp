package com.oromero.cleandemoapp.data.rest;

import com.google.gson.Gson;
import com.oromero.cleandemoapp.data.mapper.UserBeanMapper;
import com.oromero.cleandemoapp.data.model.ResponseDTO;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.converter.GsonConverter;

/**
 * Created by oromero on 02/03/15.
 */
public class UserRandomRestImpl implements UserRandomRest {

    private static final String ENDPOINT = "http://api.randomuser.me";
    private static final int RESULTS = 100;

    private UserBeanMapper userBeanMapper;

    public UserRandomRestImpl(UserBeanMapper userBeanMapper) {
        this.userBeanMapper = userBeanMapper;
    }

    @Override
    public void getPeople() {
        RandomUserApi client = getClient();

        client.getPeople(RESULTS, new Callback<ResponseDTO>() {
            @Override
            public void success(ResponseDTO responseDTO, Response response) {
//                peopleDataCallback.onGetPeopleSuccess(userBeanMapper.transform(responseDTO.getResults()));
            }

            @Override
            public void failure(RetrofitError error) {
//                peopleDataCallback.onGetPeopleFailed(error.getMessage());
            }
        });
    }

    @Override
    public void getCharacter(String id) {
        RandomUserApi client = getClient();
        client.getCharacter(id, new Callback<ResponseDTO>() {
            @Override
            public void success(ResponseDTO responseDTO, Response response) {
//                characterDataCallback.onGetCharacterSuccess(userBeanMapper.transform(responseDTO.getResults().get(0)));
            }

            @Override
            public void failure(RetrofitError error) {
//                characterDataCallback.onGetChareacterFailed(error.getMessage());
            }
        });
    }

    private RandomUserApi getClient() {
        RestAdapter.Builder builder = new RestAdapter.Builder().setEndpoint(ENDPOINT).setLogLevel(RestAdapter.LogLevel.FULL).setConverter(new GsonConverter(new Gson()));
        RestAdapter restAdapter = builder.build();
        return restAdapter.create(RandomUserApi.class);
    }
}
