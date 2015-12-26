package com.oromero.cleandemoapp.ui;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.oromero.cleandemoapp.R;
import com.oromero.cleandemoapp.presentation.model.PeoplePresentationModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by oromero on 03/03/15.
 */
public class PeopleAdapter extends RecyclerView.Adapter<PeopleViewHolder> {

    private List<PeoplePresentationModel> data = new ArrayList<>();

    private View.OnClickListener listener;

    @Override
    public PeopleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_people, parent, false);
        PeopleViewHolder peopleViewHolder = new PeopleViewHolder(itemView, parent.getContext(), listener);
        return peopleViewHolder;
    }

    @Override
    public void onBindViewHolder(PeopleViewHolder holder, int position) {
        holder.render(data.get(position));
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setData(List<PeoplePresentationModel> data) {
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    public void setListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    public PeoplePresentationModel getPeopleSelected(int position) {
        return data.get(position);
    }
}