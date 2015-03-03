package com.oromero.cleandemoapp.domain.interactor;

import com.oromero.cleandemoapp.domain.callback.PeoplePresentationCallback;

/**
 * Created by oromero on 03/03/15.
 */
public interface PeopleInteractor {

    public void getPeople(PeoplePresentationCallback peoplePresentationCallback);
}
