package com.oromero.cleandemoapp.di;


import com.oromero.cleandemoapp.common.CleanApp;
import com.oromero.cleandemoapp.domain.interactor.CharacterInteractor;
import com.oromero.cleandemoapp.domain.interactor.PeopleInteractor;
import com.oromero.cleandemoapp.presentation.mapper.CharacterPresentationMapper;
import com.oromero.cleandemoapp.presentation.mapper.CharacterPresentationMapperImpl;
import com.oromero.cleandemoapp.presentation.mapper.PeoplePresentationMapper;
import com.oromero.cleandemoapp.presentation.mapper.PeoplePresentationMapperImpl;

import dagger.Module;
import dagger.Provides;


/**
 * Created by oromero on 02/03/15.
 */
@Module(injects = CleanApp.class, library = true, includes = DataModule.class)
public class DomainModule {

    @Provides
    public PeopleInteractor providePeopleInteractor(PeopleInteractor peopleInteractor) {
        return peopleInteractor;
    }

    @Provides
    public PeoplePresentationMapper providePeoplePresentationMapper(PeoplePresentationMapperImpl peoplePresentationMapper) {
        return peoplePresentationMapper;
    }

    @Provides
    public CharacterInteractor provideCharacterInteractor(CharacterInteractor characterInteractor) {
        return characterInteractor;
    }

    @Provides
    public CharacterPresentationMapper provideCharacterPresentationMapper(CharacterPresentationMapperImpl characterPresentationMapper){
        return characterPresentationMapper;
    }
}
