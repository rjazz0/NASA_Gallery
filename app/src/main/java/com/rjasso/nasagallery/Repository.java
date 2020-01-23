package com.rjasso.nasagallery;

import com.rjasso.nasagallery.model.NasaAPI;
import com.rjasso.nasagallery.model.RetrofitClient;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;

public class Repository {
    public Call<List<NasaAPI>> getImages() {
        HashMap<String,String> map = new HashMap<>();
        map.put("api_key","11wEDuC5loNXwMNJE4I97IMAHrVtPQ2uKfIoeRj1");
        return RetrofitClient.getInstance().getImages(map);
    }
}
