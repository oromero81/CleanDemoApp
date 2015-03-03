package com.oromero.cleandemoapp.presentation.view.people;

import android.os.Bundle;

import com.oromero.cleandemoapp.R;
import com.oromero.cleandemoapp.presentation.view.BaseActivity;


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
