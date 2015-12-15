package com.oromero.cleandemoapp.di;

import android.content.Context;

import com.oromero.cleandemoapp.common.CleanApp;

import dagger.Module;
import dagger.Provides;

/**
 * Created by oromero on 02/03/15.
 */
@Module(
        includes = {
                DataModule.class, UiModule.class, DomainModule.class, PresentationModule.class
        },
        injects = CleanApp.class,
        library = true
)
public class AppModule {
    private CleanApp cleanApp;

    public AppModule(CleanApp cleanApp) {
        this.cleanApp = cleanApp;
    }

    @Provides
    public Context provideContext() {
        return cleanApp.getApplicationContext();
    }
}