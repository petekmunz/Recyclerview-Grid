package com.example.pmuny.gridrecyclermoviesapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pmuny.gridrecyclermoviesapi.API_Interface.API_Interface;
import com.example.pmuny.gridrecyclermoviesapi.Model.Movies_POJO;
import com.example.pmuny.gridrecyclermoviesapi.Retrofit_Client.Retrofit_Client;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class MoviesActivity extends AppCompatActivity {
    String movieInfo;
    ImageView imageView;
    TextView textView;
    API_Interface api_interface;
    CompositeDisposable disposable = new CompositeDisposable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);
        imageView = findViewById(R.id.movie_image);
        textView = findViewById(R.id.movie_details);

        imageView.setImageResource(getIntent().getIntExtra("movies_id",00));

        Retrofit retrofit = Retrofit_Client.getInstance();
        api_interface = retrofit.create(API_Interface.class);
        api_interface.getMoviesDetails()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Movies_POJO>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Movies_POJO movies_pojo) {
                        movieInfo = movies_pojo.getPlot();
                        textView.setText(movieInfo);
                    }

                    @Override
                    public void onError(Throwable e) {
                        textView.setText(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
