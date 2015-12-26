package com.oromero.cleandemoapp.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.oromero.cleandemoapp.R;
import com.oromero.cleandemoapp.presentation.model.PeoplePresentationModel;
import com.squareup.picasso.Picasso;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by oromero on 03/03/15.
 */
public class PeopleViewHolder extends RecyclerView.ViewHolder {

    @InjectView(R.id.photo_imageView)
    ImageView photo_imageView;
    @InjectView(R.id.name_textView)
    TextView name_textView;
    @InjectView(R.id.mail_textView)
    TextView mail_textView;

    private Context context;

    public PeopleViewHolder(View itemView, Context context, View.OnClickListener listener) {
        super(itemView);
        ButterKnife.inject(this, itemView);
        this.context = context;
        if (listener != null) {
            itemView.setOnClickListener(listener);
        }
    }

    public void render(PeoplePresentationModel model) {
        Picasso.with(context).load(model.getImage()).placeholder(R.drawable.image_placeholder).into(photo_imageView);
        name_textView.setText(model.getName());
        mail_textView.setText(model.getMail());
    }
}