package com.oromero.cleandemoapp.presentation.invoker;

/**
 * Created by Oscar on 20/12/15.
 */
public class TheExecutor {

    private BackgroundInvoker executor;
    private Buzzer buzzer;

    public TheExecutor(BackgroundInvoker executor, Buzzer buzzer) {
        this.executor = executor;
        this.buzzer = buzzer;
    }

    public void postOnBackgroundThread(Runnable runnable) {
        executor.run(runnable);
    }

    public void broadcastEvent(Object object) {
        buzzer.broadcastEvent(object);
    }
}