package com.oromero.cleandemoapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ViewFlipper;

import com.oromero.cleandemoapp.R;
import com.oromero.cleandemoapp.di.PeopleModule;
import com.oromero.cleandemoapp.presentation.model.PeoplePresentationModel;
import com.oromero.cleandemoapp.presentation.presenter.PeoplePresenter;
import com.oromero.cleandemoapp.presentation.view.people.PeoplePresenterView;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by oromero on 02/03/15.
 */
public class PeopleFragment extends BaseFragment implements PeoplePresenterView {

    private static final int FLIPPER_LOADING = 0;
    private static final int FLIPPER_LIST = 1;
    private static final int FLIPPER_NO_DATA = 2;

    @InjectView(R.id.people_list)
    RecyclerView people_list;
    @InjectView(R.id.viewSwitcher)
    ViewFlipper viewFlipper;
    @Inject
    PeoplePresenter peoplePresenter;
    @Inject
    PeopleAdapter peopleAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_people, container, false);
        ButterKnife.inject(this, rootView);
        people_list.setAdapter(peopleAdapter);
        people_list.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        peopleAdapter.setListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedPosition = people_list.getChildAdapterPosition(view);
                PeoplePresentationModel cell = peopleAdapter.getPeopleSelected(selectedPosition);
                Intent intent = new Intent(getActivity(), CharacterActivity.class);
                intent.putExtra(CharacterActivity.EXTRA_ID, cell.getId());
                startActivity(intent);
            }
        });

        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();
        peoplePresenter.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        peoplePresenter.populateList();
    }

    @Override
    public void onStop() {
        super.onStop();
        peoplePresenter.onStop();
    }

    @Override
    protected List<Object> getModules() {
        return Arrays.<Object>asList(new PeopleModule(this));
    }

    @Override
    public void drawList(List<PeoplePresentationModel> peoplePresentationModels) {
        peopleAdapter.setData(peoplePresentationModels);
        viewFlipper.setDisplayedChild(FLIPPER_LIST);
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