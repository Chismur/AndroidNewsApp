package com.example.kingm.androidnewsapp.ui.gibdd.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.kingm.androidnewsapp.R;


/**
 * Created by kingm on 18.02.2018.
 */

public class NewsHolder extends RecyclerView.ViewHolder{

    TextView value , name, description;
    LinearLayout layout;

    public NewsHolder(View itemView) {
        super(itemView);

        value = (TextView) itemView.findViewById(R.id.text_value);
        name = (TextView) itemView.findViewById(R.id.text_name);
        description = (TextView) itemView.findViewById(R.id.text_description);
        layout = (LinearLayout) itemView.findViewById(R.id.linear_item);

    }
}
