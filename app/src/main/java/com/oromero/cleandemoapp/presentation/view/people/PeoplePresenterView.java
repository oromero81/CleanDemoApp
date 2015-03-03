package com.oromero.cleandemoapp.presentation.view.people;

import com.oromero.cleandemoapp.presentation.model.PeoplePresentationModel;
import com.oromero.cleandemoapp.presentation.presenter.PresenterView;

import java.util.List;

/**
 * Created by oromero on 03/03/15.
 */
public interface PeoplePresenterView extends PresenterView {

    public void drawList(List<PeoplePresentationModel>peoplePresentationModels);
}
