package com.oromero.cleandemoapp.presentation.invoker;

/**
 * Created by Oscar on 20/12/15.
 */
public interface BackgroundInvoker<T extends Runnable> {
    void run(T runnable);
}