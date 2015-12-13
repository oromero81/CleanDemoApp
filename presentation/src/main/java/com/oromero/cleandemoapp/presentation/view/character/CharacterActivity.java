package com.oromero.cleandemoapp.presentation.view.character;

import android.os.Bundle;

import com.oromero.cleandemoapp.R;
import com.oromero.cleandemoapp.presentation.view.BaseActivity;

public class CharacterActivity extends BaseActivity {

    public static final String EXTRA_ID = "extra_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character);
        String id = getIntent().getStringExtra(EXTRA_ID);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, CharacterFragment.newInstance(id))
                    .commit();
        }
    }


}
