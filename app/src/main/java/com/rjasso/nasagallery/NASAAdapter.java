package com.rjasso.nasagallery;

import android.content.Intent;
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
        TextView dateTextView = holder.itemView.findViewById(R.id.dateTextView);
        NasaAPI image = picturesList.get(position);
        ImageView imageView = holder.itemView.findViewById(R.id.imageView);
        titleTextView.setText(image.getCaption());
        dateTextView.setText(image.getDate());
        Picasso.get().load(Constants.IMAGES_LOCATION + image.getImage() + Constants.JPG).into(imageView);
        holder.itemView.setOnClickListener((View v) -> {
                Intent intent = new Intent(holder.itemView.getContext(), PictureActivity.class);
                intent.putExtra(Constants.PICTURE_URL, Constants.IMAGES_LOCATION + image.getImage() + Constants.JPG);
                intent.putExtra(Constants.PICTURE_NAME, image.getCaption());
                holder.itemView.getContext().startActivity(intent);
        });

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
