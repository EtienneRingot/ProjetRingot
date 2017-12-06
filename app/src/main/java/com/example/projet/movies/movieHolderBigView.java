package com.example.projet.movies;

import android.view.View;
import android.widget.ImageView;
import android.support.v7.widget.RecyclerView;

public class movieHolderBigView extends RecyclerView.ViewHolder  {

    ImageView movieImage;

    public movieHolderBigView(View itemViewMovie) {
        super(itemViewMovie);
        movieImage= (ImageView) itemView.findViewById(R.id.movie_image);

    }
}
