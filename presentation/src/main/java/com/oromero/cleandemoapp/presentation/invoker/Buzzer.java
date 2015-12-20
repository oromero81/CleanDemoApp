package com.oromero.cleandemoapp.presentation.invoker;

/**
 * Created by Oscar on 20/12/15.
 */
public interface Buzzer {
    void broadcastEvent(Object event);
    void registerForEvents(Object observer);
    void unregisterForEvents(Object observer);
}