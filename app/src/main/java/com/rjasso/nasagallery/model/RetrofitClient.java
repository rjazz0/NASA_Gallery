package com.rjasso.nasagallery.model;

import com.rjasso.nasagallery.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RetrofitClient {


    private static Retrofit instance;

    private RetrofitClient(){}

    public static API getInstance() {
        if (instance == null) {
            instance = new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(Constants.BASEURL)
                    .build();

        }
        return instance.create(API.class);
    }

}
