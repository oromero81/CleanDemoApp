package com.oromero.cleandemoapp.di;


import com.oromero.cleandemoapp.domain.interactor.CharacterInteractor;
import com.oromero.cleandemoapp.domain.interactor.PeopleInteractor;
import com.oromero.cleandemoapp.domain.repository.CharacterRepository;
import com.oromero.cleandemoapp.domain.repository.PeopleRepository;
import com.oromero.cleandemoapp.presentation.mapper.CharacterPresentationMapper;
import com.oromero.cleandemoapp.presentation.mapper.CharacterPresentationMapperImpl;
import com.oromero.cleandemoapp.presentation.mapper.PeoplePresentationMapper;
import com.oromero.cleandemoapp.presentation.mapper.PeoplePresentationMapperImpl;

import dagger.Module;
import dagger.Provides;


/**
 * Created by oromero on 02/03/15.
 */
@Module(
        complete = false,
        library = true
)
public class DomainModule {

    @Provides
    public PeopleInteractor providePeopleInteractor(PeopleRepository peopleRepository) {
        return new PeopleInteractor(peopleRepository);
    }

    @Provides
    public PeoplePresentationMapper providePeoplePresentationMapper(){
        return new PeoplePresentationMapperImpl();
    }

    @Provides
    public CharacterInteractor provideCharacterInteractor(CharacterRepository characterRepository) {
        return new CharacterInteractor(characterRepository);
    }

    @Provides
    public CharacterPresentationMapper provideCharacterPresentationMapper() {
        return new CharacterPresentationMapperImpl();
    }
}