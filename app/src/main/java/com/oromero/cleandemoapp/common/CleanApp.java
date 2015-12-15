package com.oromero.cleandemoapp.common;

import android.app.Application;

import com.oromero.cleandemoapp.di.AppModule;

import dagger.ObjectGraph;

/**
 * Created by oromero on 02/03/15.
 */
public class CleanApp extends Application {

    private ObjectGraph objectGraph;

    @Override
    public void onCreate() {
        super.onCreate();
        initObjectGraph();
    }

    private void initObjectGraph() {
        objectGraph = ObjectGraph.create(new AppModule(this));
        inject(this);
    }

    public void inject(Object object) {
        objectGraph.inject(object);
    }

    public ObjectGraph createScopedGraph(Object... modules) {
        return objectGraph.plus(modules);
    }

    public ObjectGraph getGraph() {
        return objectGraph;
    }
}