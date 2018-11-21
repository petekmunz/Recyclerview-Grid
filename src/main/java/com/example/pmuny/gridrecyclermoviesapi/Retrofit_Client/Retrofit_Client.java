package com.example.pmuny.gridrecyclermoviesapi.Retrofit_Client;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Retrofit_Client {

        private static String apikey = "13273488";
        private static Retrofit ourInstance;

        public static Retrofit getInstance() {
            if (ourInstance==null){
                ourInstance = new Retrofit.Builder()
                        .baseUrl("http://www.omdbapi.com/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .build();

            }
            return ourInstance;
        }
}
