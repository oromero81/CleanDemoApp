package com.oromero.cleandemoapp.di;

import com.oromero.cleandemoapp.data.mapper.UserDTOMapper;
import com.oromero.cleandemoapp.data.mapper.UserDTOMapperImpl;
import com.oromero.cleandemoapp.data.repository.CharacterRepositoryImpl;
import com.oromero.cleandemoapp.data.repository.PeopleRepositoryImpl;
import com.oromero.cleandemoapp.data.rest.RandomUserApi;
import com.oromero.cleandemoapp.data.rest.UserRandomNetworkDataSource;
import com.oromero.cleandemoapp.data.rest.UserRandomNetworkDataSourceImpl;
import com.oromero.cleandemoapp.domain.repository.CharacterRepository;
import com.oromero.cleandemoapp.domain.repository.PeopleRepository;

import dagger.Module;
import dagger.Provides;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by oromero on 02/03/15.
 */
@Module(
        complete = false,
        library = true
)
public class DataModule {
    private static final String ENDPOINT = "http://api.randomuser.me";

    @Provides
    public RandomUserApi provideRandomUserApi() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(RandomUserApi.class);
    }

    @Provides
    public UserDTOMapper provideUserBeanMapper() {
        return new UserDTOMapperImpl();
    }

    @Provides
    public UserRandomNetworkDataSource provideUserRandomRest(UserDTOMapper userDTOMapper, RandomUserApi randomUserApi) {
        return new UserRandomNetworkDataSourceImpl(randomUserApi, userDTOMapper);
    }

    @Provides
    public PeopleRepository providePeopleRepository(UserRandomNetworkDataSource userRandomNetworkDataSource) {
        return new PeopleRepositoryImpl(userRandomNetworkDataSource);
    }

    @Provides
    public CharacterRepository provideCharacterRepository(UserRandomNetworkDataSource userRandomNetworkDataSource) {
        return new CharacterRepositoryImpl(userRandomNetworkDataSource);
    }
}