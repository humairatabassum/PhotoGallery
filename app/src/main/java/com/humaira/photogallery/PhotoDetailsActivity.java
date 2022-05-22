package com.humaira.photogallery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;


public class PhotoDetailsActivity extends AppCompatActivity {

    ImageView image;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_details);

        image = findViewById(R.id.ivImage);
        text = findViewById(R.id.tvText);

        Intent intent = getIntent();
        String link = intent.getStringExtra("link");
        String desc = intent.getStringExtra("desc");

        text.setText(desc);

        try {
            Glide.with(this).load(link).into(image);
        } catch (Exception e) {
            image.setImageResource(R.drawable.ic_launcher_background);
        }

    }

}