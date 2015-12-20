package com.oromero.cleandemoapp.presentation.invoker;

import de.greenrobot.event.EventBus;

/**
 * Created by Oscar on 21/12/15.
 */
public class EventBusBuzzer implements com.oromero.cleandemoapp.domain.interactor.Buzzer {
    @Override
    public void broadcastEvent(Object event) {
        EventBus.getDefault().post(event);
    }
}