package com.rjasso.nasagallery.model;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static final String BASEURL = "https://api.nasa.gov/EPIC/api/natural/date/";
    private static Retrofit instance;

    private RetrofitClient(){}

    public static API getInstance() {
        if (instance == null) {
            instance = new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(BASEURL)
                    .build();

        }
        return instance.create(API.class);
    }

}
