package com.oromero.cleandemoapp.ui;

import android.os.Bundle;

import com.oromero.cleandemoapp.R;


public class PeopleActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new PeopleFragment())
                    .commit();
        }
    }
}
