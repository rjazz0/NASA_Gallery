package com.rjasso.nasagallery.model;

import com.rjasso.nasagallery.NasaViewModel;
import com.rjasso.nasagallery.Repository;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class NasaViewModelFactory implements ViewModelProvider.Factory {
    private Repository mRepository;


    @Override
    @NonNull
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(NasaViewModel.class)) {
            return (T) new NasaViewModel(mRepository);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }

    public NasaViewModelFactory(Repository repository) {
        mRepository = repository;
    }
}
