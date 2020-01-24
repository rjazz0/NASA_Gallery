package com.rjasso.nasagallery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;

import com.rjasso.nasagallery.model.NasaAPI;
import com.rjasso.nasagallery.model.NasaViewModelFactory;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {
    private ArrayList<NasaAPI> pictures = new ArrayList<>();
    private NASAAdapter nasaAdapter = new NASAAdapter(pictures);
    private NasaViewModel viewModel;
    private SwipeRefreshLayout mSwipeRefreshLayout;


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

        mSwipeRefreshLayout = findViewById(R.id.swipe_container);
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary,
                android.R.color.holo_green_dark,
                android.R.color.holo_orange_dark,
                android.R.color.holo_blue_dark);

        mSwipeRefreshLayout.post(() -> mSwipeRefreshLayout.setRefreshing(true));

        viewModel= new NasaViewModelFactory(new Repository()).create(NasaViewModel.class);
        viewModel.getImages().observe(this, (List<NasaAPI> nasaAPIS) -> {
                nasaAdapter.updateImages(nasaAPIS);
                mSwipeRefreshLayout.setRefreshing(false);
        });


    }

    @Override
    public void onRefresh() {
        viewModel.loadImages();
    }
}
