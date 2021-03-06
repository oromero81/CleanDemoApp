package com.oromero.cleandemoapp.ui.customviews;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.oromero.cleandemoapp.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by oromero on 03/03/15.
 */
public class TitleWithDescriptionView extends LinearLayout {

    @Bind(R.id.title_textView)
    TextView title_textView;
    @Bind(R.id.description_textView)
    TextView description_textView;

    public TitleWithDescriptionView(Context context) {
        super(context);
        init(context);
    }

    public TitleWithDescriptionView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public TitleWithDescriptionView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rootView = inflater.inflate(R.layout.view_title_with_description, this, true);
        ButterKnife.bind(this, rootView);
    }


    public void setTitle(String text) {
        if (text != null) {
            title_textView.setText(text);
        }
    }

    public void setDescription(String text) {
        if (text != null) {
            description_textView.setText(text);
        }
    }
}