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

class movieAdapter extends RecyclerView.Adapter<movieHolderView> {

    private Context mContext;
    private List<Movie> m;

    public movieAdapter(Context context, List<Movie> movies) {
        mContext = context;
        m = movies;
    }

    @Override
    public movieHolderView onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        Context context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.mainactivity_View, viewGroup, false);

        return new movieHolderView(view);
    }

    @Override
    public void onBindViewHolder(movieHolderView holder, int position) {

        final Movie movie = m.get(position);

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
        holder.movieTitle.setText(String.valueOf(movie.getTitle()));
        holder.movieResume.setText(String.valueOf(movie.getDescription()));
        Picasso.with(mContext).load(movie.getPoster()).into(holder.movieImage);


    }

    @Override
    public int getItemCount() {

        return m.size();
    }
}