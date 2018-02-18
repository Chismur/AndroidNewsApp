package com.example.kingm.androidnewsapp.ui.gibdd.adapter;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kingm.androidnewsapp.R;
import com.example.kingm.androidnewsapp.model.GibddSource;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kingm on 18.02.2018.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsHolder> {

    private List<GibddSource> list;

    public NewsAdapter() {
        this.list = new ArrayList<>();
    }

    @Override
    public NewsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_view, parent, false);
        return new NewsHolder(itemView);
    }

    @Override
    public void onBindViewHolder(NewsHolder holder, int position) {
        GibddSource gibddSource = list.get(position);
        holder.value.setText(gibddSource.getValue());
        holder.name.setText(gibddSource.getName());
        holder.description.setText(gibddSource.getDescription());
        if(gibddSource.isFavourite()){
            holder.layout.setBackgroundColor(Color.RED);
        }else
        {
            holder.layout.setBackgroundColor(Color.GREEN);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void update(List<GibddSource> list) {
        this.list = list;
        this.notifyDataSetChanged();
    }
}
