package com.oromero.cleandemoapp.data.rest;

import com.oromero.cleandemoapp.data.model.ResponseDTO;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by oromero on 02/03/15.
 */
public interface RandomUserApi {

    @GET("/0.4/")
    Call<ResponseDTO> getPeople(@Query("results") int results);

    @GET("/0.4/")
    Call<ResponseDTO> getCharacter(@Query("seed") String id);
}