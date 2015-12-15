package com.oromero.cleandemoapp.di;

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
@Module(
        complete = false,
        library = true
)
public class DataModule {

    @Provides
    public UserBeanMapper provideUserBeanMapper() {
        return new UserBeanMapperImpl();
    }

    @Provides
    public UserRandomRest provideUserRandomRest(UserBeanMapper userBeanMapper) {
        return new UserRandomRestImpl(userBeanMapper);
    }

    @Provides
    public PeopleRepository providePeopleRepository(UserRandomRest userRandomRest) {
        return new PeopleRepositoryImpl(userRandomRest);
    }

    @Provides
    public CharacterRepository provideCharacterRepository(UserRandomRest userRandomRest) {
        return new CharacterRepositoryImpl(userRandomRest);
    }
}