package com.oromero.cleandemoapp.presentation.module;

import com.oromero.cleandemoapp.domain.interactor.CharacterInteractor;
import com.oromero.cleandemoapp.domain.module.DomainModule;
import com.oromero.cleandemoapp.presentation.presenter.CharacterPresenter;
import com.oromero.cleandemoapp.presentation.presenter.CharacterPresenterImpl;
import com.oromero.cleandemoapp.presentation.view.character.CharacterFragment;
import com.oromero.cleandemoapp.presentation.view.character.CharacterPresenterView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by oromero on 03/03/15.
 */

@Module(injects = CharacterFragment.class, includes = DomainModule.class, complete = false)
public class CharacterModule {

    private CharacterPresenterView characterPresenterView;

    public CharacterModule(CharacterPresenterView characterPresenterView) {
        this.characterPresenterView = characterPresenterView;
    }

    @Provides
    public CharacterPresenter providesCharacterPresenter(CharacterInteractor characterInteractor) {
        return new CharacterPresenterImpl(characterPresenterView, characterInteractor);
    }
}
