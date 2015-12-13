package com.oromero.cleandemoapp.domain.interactor;

import com.oromero.cleandemoapp.domain.repository.CharacterRepository;

/**
 * Created by oromero on 03/03/15.
 */
public class CharacterInteractor implements Interactor {

    private CharacterRepository characterRepository;

    private String id;

    public CharacterInteractor(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    public void setup(String id) {
        this.id = id;
    }

//    private CharacterDataCallback characterDataCallback = new CharacterDataCallback() {
//
//        @Override
//        public void onGetCharacterSuccess(Character character) {
////            characterPresentationCallback.onGetCharacterSuccess(characterPresentationMapper.transform(character));
//        }
//
//        @Override
//        public void onGetChareacterFailed(String error) {
////            characterPresentationCallback.onGetCharacterFail(error);
//        }
//    };

    @Override
    public void run() {
        characterRepository.getCharacter(id);
    }
}