package com.humaira.photogallery;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class CustomPhotoAdapter extends ArrayAdapter<Photo> {

    private final Context context;
    private final ArrayList<Photo> values;


    public CustomPhotoAdapter(@NonNull Context context, @NonNull ArrayList<Photo> objects) {
        super(context, -1, objects);
        this.context = context;
        this.values = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.list_photo, parent, false);

        ImageView image = rowView.findViewById(R.id.ivImageList);

        try {
            Glide.with(context).load(values.get(position).getUrl()).into(image);
        } catch (Exception e) {
            image.setImageResource(R.drawable.ic_launcher_background);
        }

        return rowView;
    }
}
