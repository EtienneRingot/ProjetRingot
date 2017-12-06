package com.example.projet.movies;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class movieHolderView extends RecyclerView.ViewHolder {
    TextView movieTitle;
    TextView movieResume;
    ImageView movieImage;


    public movieHolderView(View itemViewMovie) {
        super(itemViewMovie);
        movieTitle = (TextView) itemView.findViewById(R.id.movie_title);
        movieResume = (TextView) itemView.findViewById(R.id.movie_resume);
        movieImage= (ImageView) itemView.findViewById(R.id.movie_image);

    }

}

