package com.oromero.cleandemoapp.domain.callback;

import com.oromero.cleandemoapp.data.model.CharacterDataModel;

/**
 * Created by oromero on 02/03/15.
 */
public interface CharacterDataCallback {

    public void onGetCharacterSuccess(CharacterDataModel characterDataModel);

    public void onGetChareacterFailed(String error);
}
