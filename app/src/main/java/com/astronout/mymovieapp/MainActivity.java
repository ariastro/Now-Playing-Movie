package com.astronout.mymovieapp;

import android.app.ProgressDialog;
import android.content.res.Configuration;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.astronout.mymovieapp.adapter.MoviesAdapter;
import com.astronout.mymovieapp.api.Client;
import com.astronout.mymovieapp.api.Service;
import com.astronout.mymovieapp.model.Movie;
import com.astronout.mymovieapp.model.MoviesResponse;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.main_content)
    SwipeRefreshLayout swipeRefreshLayout;

    private MoviesAdapter adapter;
    private List<Movie> movieList;
    private ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initViews();

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                initViews();
            }
        });

    }

    private void initViews(){
        pd = new ProgressDialog(this);
        pd.setMessage("Fetching Movies...");
        pd.setCancelable(false);
        pd.show();

        movieList = new ArrayList<>();
        adapter = new MoviesAdapter(this, movieList);

        if (MainActivity.this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        }else {
            recyclerView.setLayoutManager(new GridLayoutManager(this, 4));
        }

//        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
//        adapter.notifyDataSetChanged();

        loadJSON();

    }

    private void loadJSON(){
        try{
            Client client = new Client();
            Service apiService = client.getClient().create(Service.class);
            Call<MoviesResponse> call = apiService.getNowPlayingMovie(BuildConfig.THE_MOVIE_DB_API_TOKEN);
            call.enqueue(new Callback<MoviesResponse>() {
                @Override
                public void onResponse(Call<MoviesResponse> call, Response<MoviesResponse> response) {
                    List<Movie> movies = response.body().getmResults();
                    recyclerView.setAdapter(new MoviesAdapter(MainActivity.this, movies));
//                    recyclerView.smoothScrollToPosition(0);
                    if (swipeRefreshLayout.isRefreshing()){
                        swipeRefreshLayout.setRefreshing(false);
                    }
                    pd.dismiss();
                }

                @Override
                public void onFailure(Call<MoviesResponse> call, Throwable t) {
                    Log.d("Error ", t.getMessage());
                    Toast.makeText(MainActivity.this, "Aw Snap! Something went wrong!", Toast.LENGTH_SHORT).show();
                }
            });
        }catch (Exception e){
            Log.d("Error", e.getMessage());
            Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
        }
    }

}
