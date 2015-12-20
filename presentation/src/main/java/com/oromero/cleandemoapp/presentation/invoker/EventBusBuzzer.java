package com.oromero.cleandemoapp.presentation.invoker;

import de.greenrobot.event.EventBus;

/**
 * Created by Oscar on 21/12/15.
 */
public class EventBusBuzzer implements Buzzer {
    @Override
    public void broadcastEvent(Object event) {
        EventBus.getDefault().post(event);
    }

    @Override
    public void registerForEvents(Object observer) {
        EventBus.getDefault().register(observer);
    }

    @Override
    public void unregisterForEvents(Object observer) {
        if (EventBus.getDefault().isRegistered(observer)) {
            EventBus.getDefault().unregister(observer);
        }
    }
}