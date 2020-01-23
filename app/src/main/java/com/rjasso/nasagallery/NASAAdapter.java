package com.rjasso.nasagallery;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.rjasso.nasagallery.model.NasaAPI;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class NASAAdapter extends RecyclerView.Adapter<NASAAdapter.NasaViewHolder> {
    private ArrayList<NasaAPI> picturesList;
    public NASAAdapter(ArrayList<NasaAPI> pictures) {
        picturesList = pictures;
    }

    @NonNull
    @Override
    public NasaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new NasaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NasaViewHolder holder, int position) {
        TextView titleTextView = holder.itemView.findViewById(R.id.titleTextView);
        TextView authorTextView = holder.itemView.findViewById(R.id.authorTextView);
        TextView dateTextView = holder.itemView.findViewById(R.id.dateTextView);
        ImageView imageView = holder.itemView.findViewById(R.id.imageView);
        titleTextView.setText(picturesList.get(position).getCaption());
        authorTextView.setText(picturesList.get(position).getCaption());
        dateTextView.setText(picturesList.get(position).getCaption());
        Picasso.get().load("http://i.imgur.com/DvpvklR.png").into(imageView);
    }

    @Override
    public int getItemCount() {
        return picturesList.size();
    }

    public void updateImages(List<NasaAPI> nasaAPIS) {
        picturesList.clear();
        picturesList.addAll(nasaAPIS);
        notifyDataSetChanged();
    }

    class NasaViewHolder extends RecyclerView.ViewHolder {

        public NasaViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

}
