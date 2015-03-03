package com.oromero.cleandemoapp.presentation.view.people;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.oromero.cleandemoapp.R;
import com.oromero.cleandemoapp.presentation.model.PeoplePresentationModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by oromero on 03/03/15.
 */
public class PeopleAdapter extends BaseAdapter {

    private List<PeoplePresentationModel> data = new ArrayList<>();

    @Inject
    public PeopleAdapter() {
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public PeoplePresentationModel getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        PeopleCell cell;

        if (convertView == null || !(convertView instanceof PeopleCell)) {
            cell = (PeopleCell) LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_people, parent, false);
        } else {
            cell = (PeopleCell) convertView;
        }

        cell.setCell(data.get(position));

        return cell;
    }

    public void setData(List<PeoplePresentationModel> data) {
        this.data.addAll(data);
        notifyDataSetChanged();
    }
}
