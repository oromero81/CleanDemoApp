package com.oromero.cleandemoapp.presentation.invoker;

/**
 * Created by Oscar on 20/12/15.
 */
public class TheExecutor {

    private BackgroundInvoker executor;

    public TheExecutor(BackgroundInvoker executor) {
        this.executor = executor;
    }

    public void postOnBackgroundThread(Runnable runnable) {
        executor.run(runnable);
    }
}