package com.rjasso.nasagallery.model;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface API {
    @GET("2015-10-31")
    Call<List<NasaAPI>> getImages (@QueryMap HashMap<String,String> map);
}
