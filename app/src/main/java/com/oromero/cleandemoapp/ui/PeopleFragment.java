package com.oromero.cleandemoapp.ui;

import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Slide;
import android.view.Gravity;
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

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by oromero on 02/03/15.
 */
public class PeopleFragment extends BaseFragment implements PeoplePresenterView {

    private static final int FLIPPER_LOADING = 0;
    private static final int FLIPPER_LIST = 1;
    private static final int FLIPPER_NO_DATA = 2;

    @Bind(R.id.people_list)
    RecyclerView people_list;
    @Bind(R.id.viewSwitcher)
    ViewFlipper viewFlipper;
    @Inject
    PeoplePresenter peoplePresenter;
    @Inject
    PeopleAdapter peopleAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_people, container, false);
        ButterKnife.bind(this, rootView);
        setToolbar();
        setActionBarTitle(getString(R.string.app_name));
        people_list.setAdapter(peopleAdapter);
        people_list.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        peopleAdapter.setListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedPosition = people_list.getChildAdapterPosition(view);
                PeoplePresentationModel cell = peopleAdapter.getPeopleSelected(selectedPosition);

                Fragment fragment = CharacterFragment.newInstance(cell.getId());

                if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    Slide slideTransition = new Slide(Gravity.RIGHT);
                    slideTransition.setDuration(getResources().getInteger(R.integer.anim_duration_M));

                    fragment.setEnterTransition(slideTransition);
                    fragment.setAllowEnterTransitionOverlap(false);
                    fragment.setAllowReturnTransitionOverlap(false);
                }
                getFragmentManager().beginTransaction()
                        .replace(R.id.container, fragment)
                        .addToBackStack(null)
                        .commit();
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