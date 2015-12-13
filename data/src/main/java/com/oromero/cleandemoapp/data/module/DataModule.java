package com.oromero.cleandemoapp.data.module;

import com.oromero.cleandemoapp.common.CleanApp;
import com.oromero.cleandemoapp.data.mapper.UserBeanMapper;
import com.oromero.cleandemoapp.data.mapper.UserBeanMapperImpl;
import com.oromero.cleandemoapp.data.repository.CharacterRepositoryImpl;
import com.oromero.cleandemoapp.data.repository.PeopleRepositoryImpl;
import com.oromero.cleandemoapp.data.rest.UserRandomRest;
import com.oromero.cleandemoapp.data.rest.UserRandomRestImpl;
import com.oromero.cleandemoapp.domain.repository.CharacterRepository;
import com.oromero.cleandemoapp.domain.repository.PeopleRepository;

import dagger.Module;
import dagger.Provides;

/**
 * Created by oromero on 02/03/15.
 */
@Module(injects = CleanApp.class, library = true, complete = false)
public class DataModule {

    @Provides
    public UserBeanMapper provideUserBeanMapper(UserBeanMapperImpl userBeanMapper) {
        return userBeanMapper;
    }

    @Provides
    public UserRandomRest provideUserRandomRest(UserRandomRestImpl userRandomRest) {
        return userRandomRest;
    }

    @Provides
    public PeopleRepository providePeopleRepository(PeopleRepositoryImpl peopleRepository) {
        return peopleRepository;
    }

    @Provides
    public CharacterRepository provideCharacterRepository(CharacterRepositoryImpl characterRepository){
        return characterRepository;
    }

}
