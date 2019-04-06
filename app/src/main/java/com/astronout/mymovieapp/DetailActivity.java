package com.astronout.mymovieapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.astronout.mymovieapp.adapter.MoviesAdapter.EXTRA_BACKDROP;
import static com.astronout.mymovieapp.adapter.MoviesAdapter.EXTRA_OVERVIEW;
import static com.astronout.mymovieapp.adapter.MoviesAdapter.EXTRA_POSTER;
import static com.astronout.mymovieapp.adapter.MoviesAdapter.EXTRA_RATING;
import static com.astronout.mymovieapp.adapter.MoviesAdapter.EXTRA_RELEASE_DATE;
import static com.astronout.mymovieapp.adapter.MoviesAdapter.EXTRA_TITLE;

public class DetailActivity extends AppCompatActivity {

    @BindView(R.id.detail_overview)
    TextView detailOverview;
    @BindView(R.id.detail_poster)
    ImageView detailPoster;
    @BindView(R.id.detail_rating)
    TextView detailRating;
    @BindView(R.id.detail_release_date)
    TextView detailReleaseDate;
    @BindView(R.id.backdrop_movie)
    ImageView detailBackdrop;
    @BindView(R.id.detail_title)
    TextView detailTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String titleMovie = intent.getExtras().getString(EXTRA_TITLE);
        Double ratingMovie = intent.getExtras().getDouble(EXTRA_RATING);
        String rating = ratingMovie.toString();
        String releaseDateMovie = intent.getExtras().getString(EXTRA_RELEASE_DATE);
        String posterMovie = intent.getExtras().getString(EXTRA_POSTER);
        String backdropMovie = intent.getExtras().getString(EXTRA_BACKDROP);
        String overviewMovie = intent.getExtras().getString(EXTRA_OVERVIEW);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(titleMovie);
        }

        detailOverview.setText(overviewMovie);
        detailRating.setText("Rating : " + rating + "/10");
        detailReleaseDate.setText("Release Date : " + releaseDateMovie);
        detailTitle.setText(titleMovie);

        Glide.with(this)
                .load(posterMovie)
                .into(detailPoster);

        Glide.with(this)
                .load(backdropMovie)
                .into(detailBackdrop);

    }
}
