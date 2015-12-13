package com.oromero.cleandemoapp.domain.interactor;

import com.oromero.cleandemoapp.domain.callback.CharacterPresentationCallback;

/**
 * Created by oromero on 03/03/15.
 */
public interface CharacterInteractor {

    public void getCharacter(String id, CharacterPresentationCallback characterPresentationCallback);
}
