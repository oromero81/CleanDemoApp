package com.oromero.cleandemoapp.common;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by oromero on 02/03/15.
 */
@Module(injects = {CleanApp.class}, library = true)
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
