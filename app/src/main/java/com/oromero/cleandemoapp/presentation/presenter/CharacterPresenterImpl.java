package com.oromero.cleandemoapp.presentation.presenter;

import com.oromero.cleandemoapp.domain.callback.CharacterPresentationCallback;
import com.oromero.cleandemoapp.domain.interactor.CharacterInteractor;
import com.oromero.cleandemoapp.presentation.model.CharacterPresentationModel;
import com.oromero.cleandemoapp.presentation.view.character.CharacterPresenterView;

/**
 * Created by oromero on 03/03/15.
 */
public class CharacterPresenterImpl implements CharacterPresenter {

    private CharacterPresenterView characterPresenterView;
    private CharacterInteractor characterInteractor;

    public CharacterPresenterImpl(CharacterPresenterView characterPresenterView, CharacterInteractor characterInteractor) {
        this.characterPresenterView = characterPresenterView;
        this.characterInteractor = characterInteractor;
    }

    @Override
    public void getCharacter(String id) {
        if (id != null && !id.isEmpty()) {
            characterInteractor.getCharacter(id, characterPresentationCallback);
            characterPresenterView.loading();
        } else {
            characterPresenterView.noData();
        }
    }

    private CharacterPresentationCallback characterPresentationCallback = new CharacterPresentationCallback() {
        @Override
        public void onGetCharacterSuccess(CharacterPresentationModel presentationModel) {
            if (presentationModel != null) {
                characterPresenterView.drawCharacter(presentationModel);
            } else {
                characterPresenterView.noData();
            }
        }

        @Override
        public void onGetCharacterFail(String error) {
            characterPresenterView.showMessage(error);
        }
    };
}