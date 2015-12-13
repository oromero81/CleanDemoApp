package com.oromero.cleandemoapp.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.oromero.cleandemoapp.R;
import com.oromero.cleandemoapp.presentation.model.PeoplePresentationModel;
import com.squareup.picasso.Picasso;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by oromero on 03/03/15.
 */
public class PeopleCell extends LinearLayout {

    @InjectView(R.id.photo_imageView)
    ImageView photo_imageView;
    @InjectView(R.id.name_textView)
    TextView name_textView;
    @InjectView(R.id.mail_textView)
    TextView mail_textView;

    public PeopleCell(Context context) {
        super(context);
    }

    public PeopleCell(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PeopleCell(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        ButterKnife.inject(this);
    }

    public void setCell(PeoplePresentationModel model) {
        Picasso.with(getContext()).load(model.getImage()).placeholder(R.drawable.image_placeholder).into(photo_imageView);
        name_textView.setText(model.getName());
        mail_textView.setText(model.getMail());
    }
}
