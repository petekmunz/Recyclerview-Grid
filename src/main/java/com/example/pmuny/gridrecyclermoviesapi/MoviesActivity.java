package com.example.pmuny.gridrecyclermoviesapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MoviesActivity extends AppCompatActivity {
    ImageView imageView;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);
        imageView = findViewById(R.id.movie_image);
        textView = findViewById(R.id.movie_details);

        imageView.setImageResource(getIntent().getIntExtra("movies_id",00));

    }
}
