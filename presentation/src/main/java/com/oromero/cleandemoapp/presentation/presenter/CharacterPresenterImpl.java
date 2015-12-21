package com.oromero.cleandemoapp.presentation.presenter;

import com.oromero.cleandemoapp.domain.entities.Character;
import com.oromero.cleandemoapp.domain.interactor.CharacterInteractor;
import com.oromero.cleandemoapp.presentation.invoker.TheExecutor;
import com.oromero.cleandemoapp.presentation.mapper.CharacterPresentationMapper;
import com.oromero.cleandemoapp.presentation.model.CharacterPresentationModel;
import com.oromero.cleandemoapp.presentation.view.character.CharacterPresenterView;

import de.greenrobot.event.EventBus;

/**
 * Created by oromero on 03/03/15.
 */
public class CharacterPresenterImpl implements CharacterPresenter {

    private CharacterPresenterView characterPresenterView;
    private CharacterInteractor characterInteractor;
    private TheExecutor theExecutor;
    private CharacterPresentationMapper characterPresentationMapper;

    public CharacterPresenterImpl(CharacterPresenterView characterPresenterView, CharacterInteractor characterInteractor, TheExecutor theExecutor, CharacterPresentationMapper characterPresentationMapper) {
        this.characterPresenterView = characterPresenterView;
        this.characterInteractor = characterInteractor;
        this.theExecutor = theExecutor;
        this.characterPresentationMapper = characterPresentationMapper;
    }

    @Override
    public void getCharacter(String id) {
        if (id != null && !id.isEmpty()) {
            characterInteractor.setup(id);
            theExecutor.postOnBackgroundThread(characterInteractor);
            characterPresenterView.loading();
        } else {
            characterPresenterView.noData();
        }
    }

    @Override
    public void onStart() {
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
    }

    public void onEventMainThread(Character character) {
        CharacterPresentationModel presentationModel = characterPresentationMapper.transform(character);
        if (presentationModel != null) {
            characterPresenterView.drawCharacter(presentationModel);
        } else {
            characterPresenterView.noData();
        }
    }

//        public void onGetCharacterFail(String error) {
//            characterPresenterView.showMessage(error);
//        }
}