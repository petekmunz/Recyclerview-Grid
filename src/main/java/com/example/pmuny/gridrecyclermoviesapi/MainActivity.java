package com.example.pmuny.gridrecyclermoviesapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    RecyclerView mRecyclerView;
    int[] movieposters ={
            R.drawable.arrival,
            R.drawable.atomicblonde,
            R.drawable.babydriver,
            R.drawable.breakingdawn,
            R.drawable.dunkirk,
            R.drawable.infinitywars,
            R.drawable.insidious,
            R.drawable.logan,
            R.drawable.mifallout,
            R.drawable.wonderwoman
    };
    RecyclerView.LayoutManager mLayoutManager;
    RecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.recycler_view);
        mLayoutManager = new GridLayoutManager(this,2);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(mLayoutManager);
        adapter = new RecyclerAdapter(movieposters,this);
        mRecyclerView.setAdapter(adapter);

    }
}
