package com.example.pmuny.gridrecyclermoviesapi;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.PosterViewHolder>  {

    int[] movieposters;
    Context context;

    public RecyclerAdapter (int[]movieposters,Context context){

        this.movieposters = movieposters;
        this.context = context;
    }
    @NonNull
    @Override
    public PosterViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.posters_layout,viewGroup,false);
        PosterViewHolder posterViewHolder = new PosterViewHolder(view,context,movieposters);
        return posterViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PosterViewHolder viewHolder, int position) {
        int imageId = movieposters[position];
        viewHolder.poster.setImageResource(imageId);
        viewHolder.posterTitle.setText("Movie " +position);

    }

    @Override
    public int getItemCount() {
        return movieposters.length;
    }



    public static class PosterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView poster;
        TextView posterTitle;
        Context context;
        int[] movieposters;

        public PosterViewHolder(@NonNull View itemView,Context context,int[]moviesposters) {
            super(itemView);
            poster = itemView.findViewById(R.id.posters);
            posterTitle = itemView.findViewById(R.id.poster_title);
            itemView.setOnClickListener(this);
            this.context = context;
            this.movieposters = moviesposters;
        }

        @Override
        public void onClick(View v) {

            Intent intent = new Intent(context,MoviesActivity.class);
            intent.putExtra("movies_id",movieposters[getAdapterPosition()]);
            context.startActivity(intent);

        }
    }
}
