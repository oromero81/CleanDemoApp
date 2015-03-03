package com.oromero.cleandemoapp.presentation.presenter;

/**
 * Created by oromero on 03/03/15.
 */
public interface PresenterView {

    public void showMessage(String message);
    public void loading();
    public void noData();
}
