package com.oromero.cleandemoapp.ui;

import android.support.v7.app.AppCompatActivity;

/**
 * Created by oromero on 02/03/15.
 */
public class BaseActivity extends AppCompatActivity{


    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() > 0) {
            getFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }
}
