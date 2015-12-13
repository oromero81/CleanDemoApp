package com.oromero.cleandemoapp.domain.module;

import com.oromero.cleandemoapp.common.CleanApp;
import com.oromero.cleandemoapp.data.module.DataModule;
import com.oromero.cleandemoapp.domain.interactor.CharacterInteractor;
import com.oromero.cleandemoapp.domain.interactor.CharacterInteractorImpl;
import com.oromero.cleandemoapp.domain.interactor.PeopleInteractor;
import com.oromero.cleandemoapp.domain.interactor.PeopleInteractorImpl;
import com.oromero.cleandemoapp.domain.mapper.CharacterPresentationMapper;
import com.oromero.cleandemoapp.domain.mapper.CharacterPresentationMapperImpl;
import com.oromero.cleandemoapp.domain.mapper.PeoplePresentationMapper;
import com.oromero.cleandemoapp.domain.mapper.PeoplePresentationMapperImpl;

import dagger.Module;
import dagger.Provides;

/**
 * Created by oromero on 02/03/15.
 */
@Module(injects = CleanApp.class, library = true, includes = DataModule.class)
public class DomainModule {

    @Provides
    public PeopleInteractor providePeopleInteractor(PeopleInteractorImpl peopleInteractor) {
        return peopleInteractor;
    }

    @Provides
    public PeoplePresentationMapper providePeoplePresentationMapper(PeoplePresentationMapperImpl peoplePresentationMapper) {
        return peoplePresentationMapper;
    }

    @Provides
    public CharacterInteractor provideCharacterInteractor(CharacterInteractorImpl characterInteractor) {
        return characterInteractor;
    }

    @Provides
    public CharacterPresentationMapper provideCharacterPresentationMapper(CharacterPresentationMapperImpl characterPresentationMapper){
        return characterPresentationMapper;
    }
}
