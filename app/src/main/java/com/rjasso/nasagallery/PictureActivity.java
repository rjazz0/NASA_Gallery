package com.rjasso.nasagallery;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class PictureActivity extends AppCompatActivity {
    private ImageView pictureImageView;
    private TextView pictureTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture);
        pictureImageView = findViewById(R.id.pictureImageView);
        pictureTextView = findViewById(R.id.pictureTextView);

        if (getIntent() != null && getIntent().getExtras() != null) {
            if (getIntent().getExtras().getString(Constants.PICTURE_URL) != null) {
                String pictureUrl = getIntent().getExtras().getString(Constants.PICTURE_URL);
                Picasso.get().load(pictureUrl).into(pictureImageView);
            }
            if (getIntent().getExtras().getString(Constants.PICTURE_NAME) != null) {
                String pictureName = getIntent().getExtras().getString(Constants.PICTURE_NAME);
                pictureTextView.setText(pictureName);
            }

        }


    }
}
