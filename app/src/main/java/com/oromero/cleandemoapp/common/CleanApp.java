package com.oromero.cleandemoapp.common;

import android.app.Application;

import com.oromero.cleandemoapp.di.DataModule;
import com.oromero.cleandemoapp.domain.module.DomainModule;

import java.util.Arrays;
import java.util.List;

import dagger.ObjectGraph;

/**
 * Created by oromero on 02/03/15.
 */
public class CleanApp extends Application {

    private ObjectGraph objectGraph;

    @Override
    public void onCreate() {
        super.onCreate();
        objectGraph = ObjectGraph.create(getModules().toArray());
        objectGraph.inject(this);
    }

    private List<Object> getModules() {
        return Arrays.<Object>asList(new AppModule(this), new DomainModule(), new DataModule());
    }

    public ObjectGraph createScopedGraph(Object... modules) {
        return objectGraph.plus(modules);
    }
}
