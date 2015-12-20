package com.oromero.cleandemoapp.di;

import com.oromero.cleandemoapp.presentation.invoker.BackgroundInvoker;
import com.oromero.cleandemoapp.presentation.invoker.BackgroundInvokerImpl;
import com.oromero.cleandemoapp.domain.interactor.Buzzer;
import com.oromero.cleandemoapp.presentation.invoker.EventBusBuzzer;
import com.oromero.cleandemoapp.presentation.invoker.TheExecutor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Oscar on 15/12/15.
 */
@Module(
        complete = false,
        library = true
)
public class PresentationModule {
    @Provides
    @Singleton
    public TheExecutor provideTheExecutor(BackgroundInvoker<Runnable> backgroundInvoker) {
       return new TheExecutor(backgroundInvoker);
    }

    @Provides
    @Singleton
    public BackgroundInvoker<Runnable> provideRunnableBackgroundInvoker() {
        return new BackgroundInvokerImpl();
    }

    @Provides
    @Singleton
    public Buzzer provideBuzzer() {
        return new EventBusBuzzer();
    }
}