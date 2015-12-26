package com.oromero.cleandemoapp.ui;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.oromero.cleandemoapp.R;
import com.oromero.cleandemoapp.di.CharacterModule;
import com.oromero.cleandemoapp.presentation.model.CharacterPresentationModel;
import com.oromero.cleandemoapp.presentation.presenter.CharacterPresenter;
import com.oromero.cleandemoapp.presentation.view.character.CharacterPresenterView;
import com.oromero.cleandemoapp.ui.customviews.TitleWithDescriptionView;
import com.squareup.picasso.Picasso;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

public class CharacterFragment extends BaseFragment implements CharacterPresenterView {

    private static final int FLIPPER_LOADING = 0;
    private static final int FLIPPER_CHARACTER = 1;
    private static final int FLIPPER_NO_DATA = 2;
    private static final String ARGS_ID = "args_id";

    @Bind(R.id.viewFlipper)
    ViewFlipper viewFlipper;
    @Bind(R.id.photo_imageView)
    ImageView photoImageView;
    @Bind(R.id.name_layout)
    TitleWithDescriptionView nameLayout;
    @Bind(R.id.mail_layout)
    TitleWithDescriptionView mailLayout;
    @Bind(R.id.username_layout)
    TitleWithDescriptionView usernameLayout;
    @Bind(R.id.password_layout)
    TitleWithDescriptionView passwordLayout;
    @Bind(R.id.address_layout)
    TitleWithDescriptionView addressLayout;
    @Bind(R.id.phone_layout)
    TitleWithDescriptionView phoneLayout;
    @Bind(R.id.cell_layout)
    TitleWithDescriptionView cellLayout;
    @Bind(R.id.birthday_layout)
    TitleWithDescriptionView birthdayLayout;

    @Inject
    CharacterPresenter characterPresenter;
    private String id;

    public static Fragment newInstance(String id) {
        Fragment fragment = new CharacterFragment();
        Bundle args = new Bundle();
        args.putString(ARGS_ID, id);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            id = getArguments().getString(ARGS_ID);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_character, container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();
        characterPresenter.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        characterPresenter.getCharacter(id);
    }

    @Override
    public void onStop() {
        super.onStop();
        characterPresenter.onStop();
    }

    @Override
    protected List<Object> getModules() {
        return Arrays.<Object>asList(new CharacterModule(this));
    }

    @Override
    public void drawCharacter(CharacterPresentationModel presentationModel) {
        viewFlipper.setDisplayedChild(FLIPPER_CHARACTER);

        Picasso.with(getActivity()).load(presentationModel.getImage()).placeholder(R.drawable.image_placeholder).into(photoImageView);

        nameLayout.setTitle(getString(R.string.character_title_name));
        nameLayout.setDescription(presentationModel.getName());

        mailLayout.setTitle(getString(R.string.character_title_mail));
        mailLayout.setDescription(presentationModel.getMail());

        usernameLayout.setTitle(getString(R.string.character_title_username));
        usernameLayout.setDescription(presentationModel.getUsername());

        passwordLayout.setTitle(getString(R.string.character_title_password));
        passwordLayout.setDescription(presentationModel.getPassword());

        addressLayout.setTitle(getString(R.string.character_title_address));
        addressLayout.setDescription(presentationModel.getAddress());

        phoneLayout.setTitle(getString(R.string.character_title_phone));
        phoneLayout.setDescription(presentationModel.getPhone());

        cellLayout.setTitle(getString(R.string.character_title_cell));
        cellLayout.setDescription(presentationModel.getCell());

        birthdayLayout.setTitle(getString(R.string.character_title_birthday));
        birthdayLayout.setDescription(presentationModel.getBirthday());
    }

    @Override
    public void showMessage(String message) {
        super.showMessage(message);
    }

    @Override
    public void loading() {
        viewFlipper.setDisplayedChild(FLIPPER_LOADING);
    }

    @Override
    public void noData() {
        viewFlipper.setDisplayedChild(FLIPPER_NO_DATA);
    }
}
