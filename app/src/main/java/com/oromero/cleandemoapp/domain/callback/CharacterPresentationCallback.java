package com.oromero.cleandemoapp.domain.callback;

import com.oromero.cleandemoapp.presentation.model.CharacterPresentationModel;

/**
 * Created by oromero on 03/03/15.
 */
public interface CharacterPresentationCallback {

    public void onGetCharacterSuccess(CharacterPresentationModel presentationModel);

    public void onGetCharacterFail(String error);
}
