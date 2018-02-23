package com.example.kingm.androidnewsapp.ui.gibdd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
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

public class FavouriteActivity extends MvpAppCompatActivity implements NewsView {

    @InjectPresenter
    FavouritePresenter favouritePresenter;

    @BindView(R.id.recycler_favourite_list)
    RecyclerView recyclerView;

    Toolbar toolbar;

    private NewsAdapter newsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite);

        ButterKnife.bind(this);


        initRecyclerView();
        initToolbar();
        setTitle("Favourites");

        favouritePresenter.getFavouritesFromDb();

    }

    private void initRecyclerView() {
        newsAdapter = new NewsAdapter(new NewsAdapter.LongClickListener() {
            @Override
            public void longClick(GibddSource source, int position) {
                favouritePresenter.clickedFavourite(source);
                newsAdapter.deleteItem(position);
            }
        });
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
                //переход в NewsActivity
                startActivity(new Intent(this, NewsActivity.class));
                break;
            case R.id.action_favourite:
                showToast("You are in Favourite");
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void showResult(List<GibddSource> list) {
        newsAdapter.update(list);
    }

    @Override
    public void changeFavourite(int position) {
        newsAdapter.changeFavourite(position);
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
