package com.example.pmuny.gridrecyclermoviesapi.API_Interface;

import com.example.pmuny.gridrecyclermoviesapi.Model.Movies_POJO;


import io.reactivex.Observable;
import retrofit2.http.GET;

public interface API_Interface {
    @GET("?t=arrival&apikey=13273488")
    Observable<Movies_POJO> getMoviesDetails();
}
