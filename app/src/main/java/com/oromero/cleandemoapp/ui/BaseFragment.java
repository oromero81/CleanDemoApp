package com.oromero.cleandemoapp.ui;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.oromero.cleandemoapp.R;
import com.oromero.cleandemoapp.common.CleanApp;

import java.util.List;

import butterknife.Bind;
import dagger.ObjectGraph;

/**
 * Created by oromero on 02/03/15.
 */
public abstract class BaseFragment extends Fragment {

    @Bind(R.id.toolbar)
    @Nullable
    protected Toolbar toolbar;

    protected ObjectGraph activityGraph;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getModules() != null) {
            activityGraph = ((CleanApp) getActivity().getApplication()).createScopedGraph(getModules().toArray());
            activityGraph.inject(this);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        activityGraph = null;
    }

    protected void setActionBarTitle(String title) {
        if (((AppCompatActivity) getActivity()).getSupportActionBar() != null) {
            ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(title);
        }
    }

    protected void showMessage(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
    }


    protected ObjectGraph getActivityGraph() {
        return activityGraph;
    }

    protected abstract List<Object> getModules();

    protected void setToolbar() {
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
    }
}