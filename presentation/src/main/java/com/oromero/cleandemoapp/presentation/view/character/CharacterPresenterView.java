package com.oromero.cleandemoapp.presentation.view.character;

import com.oromero.cleandemoapp.presentation.model.CharacterPresentationModel;
import com.oromero.cleandemoapp.presentation.presenter.PresenterView;

/**
 * Created by oromero on 03/03/15.
 */
public interface CharacterPresenterView extends PresenterView {

    void drawCharacter(CharacterPresentationModel presentationModel);
}