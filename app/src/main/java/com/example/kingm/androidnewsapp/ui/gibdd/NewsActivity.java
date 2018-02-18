package com.example.kingm.androidnewsapp.ui.gibdd;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.kingm.androidnewsapp.R;
import com.example.kingm.androidnewsapp.model.GibddSource;
import com.example.kingm.androidnewsapp.ui.gibdd.adapter.NewsAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by kingm on 18.02.2018.
 */

public class NewsActivity extends MvpAppCompatActivity implements NewsView {

    @InjectPresenter
    NewsPresenter newsPresenter;

    @BindView(R.id.recycler_news_list)
    RecyclerView recyclerView;

    Toolbar toolbar;

    private NewsAdapter newsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        ButterKnife.bind(this);

        initRecyclerView();
        initToolbar();

        newsPresenter.getRequestNews();

    }

    private void initRecyclerView() {
        newsAdapter = new NewsAdapter();
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(newsAdapter);
    }

    private void initToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_news:
                break;
            case R.id.action_favourite:
                startActivity(new Intent(this, FavouriteActivity.class));
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void showResult(List<GibddSource> list) {
        newsAdapter.update(list);
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
