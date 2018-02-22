package com.example.kingm.androidnewsapp.ui.gibdd.adapter;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kingm.androidnewsapp.R;
import com.example.kingm.androidnewsapp.model.GibddSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by kingm on 18.02.2018.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsHolder> {

    private List<GibddSource> list;

    private LongClickListener longClickListener;

    public NewsAdapter(LongClickListener longClickListener) {
        this.longClickListener = longClickListener;
        this.list = new ArrayList<>();
    }


    @Override
    public NewsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_view, parent, false);
        return new NewsHolder(itemView);
    }

    @Override
    public void onBindViewHolder(NewsHolder holder, final int position) {
        final GibddSource gibddSource = list.get(position);
        holder.value.setText(gibddSource.getValue());
        holder.name.setText(gibddSource.getName());
        holder.description.setText(gibddSource.getDescription());
        if (gibddSource.isFavourite()) {
            holder.layout.setBackgroundColor(Color.RED);
        } else {
            holder.layout.setBackgroundColor(Color.GREEN);
        }

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                longClickListener.longClick(gibddSource, position);
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void update(List<GibddSource> list) {
        this.list = list;
        this.notifyDataSetChanged();
    }

    public void refreshItem(int position) {
        notifyItemChanged(position);
    }

    public void compareLists(List<GibddSource> favouriteList) {
        //TODO compareLists
        Log.e("ID_FAV", "hello im in");
        Log.e("ID_FAV", String.valueOf(list.size()) + " " + favouriteList.size());
        for (int i = 0; i < this.list.size(); i++) {
            for (GibddSource favourite : favouriteList) {
                Log.e("ID_FAV", String.valueOf(list.get(i).getId()) + " ?= " + String.valueOf(favourite.getIdFromJson()));
                if (Objects.equals(list.get(i).getId(), favourite.getIdFromJson())) {
                    list.get(i).changeFavourite();
                    Log.e("ID_FAV", "changed " + favourite.getIdFromJson());
                    refreshItem(i);
                }
            }
        }
    }

    public interface LongClickListener {
        void longClick(GibddSource source, int position);
    }
}
