package com.oromero.cleandemoapp.domain.callback;

import com.oromero.cleandemoapp.domain.entities.CharacterDataModel;

import java.util.List;

/**
 * Created by oromero on 02/03/15.
 */
public interface PeopleDataCallback {

    public void onGetPeopleSuccess(List<CharacterDataModel>characterDataModels);
    public void onGetPeopleFailed(String error);
}
