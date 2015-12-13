package com.oromero.cleandemoapp.domain.interactor;

import com.oromero.cleandemoapp.domain.entities.CharacterDataModel;
import com.oromero.cleandemoapp.domain.callback.CharacterDataCallback;
import com.oromero.cleandemoapp.domain.callback.CharacterPresentationCallback;
import com.oromero.cleandemoapp.domain.mapper.CharacterPresentationMapper;
import com.oromero.cleandemoapp.domain.repository.CharacterRepository;

import javax.inject.Inject;

/**
 * Created by oromero on 03/03/15.
 */
public class CharacterInteractorImpl implements CharacterInteractor {

    @Inject
    CharacterRepository characterRepository;
    @Inject
    CharacterPresentationMapper characterPresentationMapper;

    CharacterPresentationCallback characterPresentationCallback;

    @Override
    public void getCharacter(String id, CharacterPresentationCallback characterPresentationCallback) {
        this.characterPresentationCallback = characterPresentationCallback;
        characterRepository.getCharacter(id, characterDataCallback);
    }

    private CharacterDataCallback characterDataCallback = new CharacterDataCallback() {

        @Override
        public void onGetCharacterSuccess(CharacterDataModel characterDataModel) {
            characterPresentationCallback.onGetCharacterSuccess(characterPresentationMapper.transform(characterDataModel));
        }

        @Override
        public void onGetChareacterFailed(String error) {
            characterPresentationCallback.onGetCharacterFail(error);
        }
    };
}