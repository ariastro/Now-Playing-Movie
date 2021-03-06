package com.astronout.mymovieapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.astronout.mymovieapp.DetailActivity;
import com.astronout.mymovieapp.R;
import com.astronout.mymovieapp.model.Movie;
import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.ViewHolder> {

    private Context context;
    private List<Movie> movieList;

    public static final String EXTRA_TITLE = "EXTRA_TITLE";
    public static final String EXTRA_RATING = "EXTRA_RATING";
    public static final String EXTRA_RELEASE_DATE = "EXTRA_RELEASE_DATE";
    public static final String EXTRA_BACKDROP = "EXTRA_BACKDROP";
    public static final String EXTRA_POSTER = "EXTRA_POSTER";
    public static final String EXTRA_OVERVIEW = "EXTRA_OVERVIEW";

    public MoviesAdapter(Context context, List<Movie> movieList) {
        this.context = context;
        this.movieList = movieList;
    }

    @NonNull
    @Override
    public MoviesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_list, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MoviesAdapter.ViewHolder holder, int position) {
        holder.titleMovie.setText(movieList.get(position).getmTitle());
        holder.overviewMovie.setText(movieList.get(position).getmOverview());
        String rating = Double.toString(movieList.get(position).getmVoteAverage());
        holder.ratingMovie.setText(rating);
        Glide.with(context)
                .asBitmap()
                .load(movieList.get(position).getmPoster())
                .into(holder.imgMovie);
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.img_movie)
        ImageView imgMovie;
        @BindView(R.id.title_movie)
        TextView titleMovie;
        @BindView(R.id.rating_movie)
        TextView ratingMovie;
        @BindView(R.id.overview_movie)
        TextView overviewMovie;


        public ViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
//                    Toast.makeText(context, movieList.get(pos).getmTitle(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(context, DetailActivity.class);
                    intent.putExtra(EXTRA_TITLE, movieList.get(pos).getmTitle());
                    intent.putExtra(EXTRA_RATING, movieList.get(pos).getmVoteAverage());
                    intent.putExtra(EXTRA_POSTER, movieList.get(pos).getmPoster());
                    intent.putExtra(EXTRA_RELEASE_DATE, movieList.get(pos).getmReleaseDate());
                    intent.putExtra(EXTRA_BACKDROP, movieList.get(pos).getmBackdrop());
                    intent.putExtra(EXTRA_OVERVIEW, movieList.get(pos).getmOverview());
                    context.startActivity(intent);
                }
            });

        }
    }

}
