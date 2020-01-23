package com.rjasso.nasagallery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.rjasso.nasagallery.model.NasaAPI;
import com.rjasso.nasagallery.model.NasaViewModelFactory;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ArrayList<NasaAPI> pictures = new ArrayList<>();
    private NASAAdapter nasaAdapter = new NASAAdapter(pictures);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(nasaAdapter);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), layoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);

        NasaViewModel viewModel= new NasaViewModelFactory(new Repository()).create(NasaViewModel.class);
        viewModel.getImages().observe(this, new Observer<List<NasaAPI>>() {
            @Override
            public void onChanged(List<NasaAPI> nasaAPIS) {
                nasaAdapter.updateImages(nasaAPIS);
            }
        });


    }
}
