package com.oromero.cleandemoapp.data.rest;

import com.oromero.cleandemoapp.data.model.ResponseDTO;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by oromero on 02/03/15.
 */
public interface RandomUserApi {

    @GET("/0.4/")
    public void getPeople(@Query("results") int results, Callback<ResponseDTO> callback);

    @GET("/0.4/")
    public void getCharacter(@Query("seed") String id, Callback<ResponseDTO> callback);
}
