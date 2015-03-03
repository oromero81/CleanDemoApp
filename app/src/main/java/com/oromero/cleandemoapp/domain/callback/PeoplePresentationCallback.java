package com.oromero.cleandemoapp.domain.callback;

import com.oromero.cleandemoapp.presentation.model.PeoplePresentationModel;

import java.util.List;

/**
 * Created by oromero on 03/03/15.
 */
public interface PeoplePresentationCallback {

    public void onGetPeopleSuccess(List<PeoplePresentationModel> peoplePresentationModels);

    public void onGetPeopleFail(String error);
}
