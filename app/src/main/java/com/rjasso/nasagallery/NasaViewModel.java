package com.rjasso.nasagallery;

import com.rjasso.nasagallery.model.NasaAPI;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NasaViewModel extends ViewModel {
    private MutableLiveData<List<NasaAPI>> images;
    private Repository mRepository;

    public NasaViewModel(Repository repository) {
        mRepository = repository;
    }

    public LiveData<List<NasaAPI>> getImages() {
        if (images == null) {
            images = new MutableLiveData<>();
            loadImages();
        }
        return images;
    }

    public void loadImages() {
        mRepository.getImages().enqueue(new Callback<List<NasaAPI>>() {
            @Override
            public void onResponse(Call<List<NasaAPI>> call, Response<List<NasaAPI>> response) {
                images.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<NasaAPI>> call, Throwable t) {
                // TODO Implement Failure logic
            }

        });
    }
}
