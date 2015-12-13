package com.oromero.cleandemoapp.ui;

import android.app.Fragment;
import android.os.Bundle;
import android.widget.Toast;

import com.oromero.cleandemoapp.common.CleanApp;

import java.util.List;

import dagger.ObjectGraph;

/**
 * Created by oromero on 02/03/15.
 */
public abstract class BaseFragment extends Fragment {

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
        if (getActivity().getActionBar() != null)
            getActivity().getActionBar().setTitle(title);
    }

    protected void showMessage(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
    }


    protected ObjectGraph getActivityGraph() {
        return activityGraph;
    }

    protected abstract List<Object> getModules();
}
