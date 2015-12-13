package com.oromero.cleandemoapp.presentation.view.people;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ViewFlipper;

import com.oromero.cleandemoapp.R;
import com.oromero.cleandemoapp.presentation.model.PeoplePresentationModel;
import com.oromero.cleandemoapp.presentation.module.PeopleModule;
import com.oromero.cleandemoapp.presentation.presenter.PeoplePresenter;
import com.oromero.cleandemoapp.presentation.view.BaseFragment;
import com.oromero.cleandemoapp.presentation.view.character.CharacterActivity;

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

    @InjectView(R.id.people_listView)
    ListView people_listView;
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
        people_listView.setAdapter(peopleAdapter);
        people_listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                PeoplePresentationModel cell = ((PeoplePresentationModel) parent.getAdapter().getItem(position));
                Intent intent = new Intent(getActivity(), CharacterActivity.class);
                intent.putExtra(CharacterActivity.EXTRA_ID, cell.getId());
                startActivity(intent);
            }
        });
        peoplePresenter.populateList();

        return rootView;
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
