package com.example.projet.movies;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.projet.movies.models.Movie;
import com.squareup.picasso.Picasso;

import java.util.List;

public class movieAdapterBigView extends RecyclerView.Adapter<movieHolderBigView> {
    private Context mContext;
    private List<Movie> movies;


    public movieAdapterBigView(Context context, List<Movie> mov) {
        mContext = context;
        movies = mov;
    }

    @Override
    public movieHolderBigView onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        final Context context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.mainactivity_bigView, viewGroup, false);
        return new movieHolderBigView(view);
    }

    @Override
    public void onBindViewHolder(movieHolderBigView holder, int position) {

        final Movie movie = movies.get(position);

        View view = holder.itemView;
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), SingleMovieActivity.class);
                Bundle extras = new Bundle();
                extras.putString(SingleMovieActivity.EXTRA_MOVIE_TITLE,movie.getTitle());
                extras.putString(SingleMovieActivity.EXTRA_MOVIE_RESUME,movie.getDescription());
                extras.putString(SingleMovieActivity.EXTRA_MOVIE_IMAGE,movie.getPoster());
                intent.putExtras(extras);
                view.getContext().startActivity(intent);
            }
        });
        Picasso.with(mContext).load(movie.getPoster()).into(holder.movieImage);
    }

    @Override
    public int getItemCount() {

        return movies.size();
    }
}
