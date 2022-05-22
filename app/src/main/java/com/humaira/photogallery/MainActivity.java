package com.humaira.photogallery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private GridView gridView;

    private String URL = "https://muthosoft.com/univ/photos/";
    private ArrayList<Photo> photos;
    private CustomPhotoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.gridView);

        httpRequest();

        gridView.setOnItemClickListener((adapterView, view, i, l) -> {
            Photo ph = photos.get(i);
            Intent intent = new Intent(MainActivity.this, PhotoDetailsActivity.class);
            intent.putExtra("link", ph.getUrl());
            intent.putExtra("desc", ph.getDetails());
            startActivity(intent);
        });


    }

    private void httpRequest() {

        photos = new ArrayList<>();
        new AsyncTask<Void, Void, String>() {
            @Override
            protected String doInBackground(Void... voids) {
                try {
                    String data = JSONParser.getInstance().makeHttpRequest(URL, "GET");

                    if (data != null) {
                        String[] pModels = data.split(",");
                        for(int i = 0; i < pModels.length; i++) {
                            String mUrl = URL + pModels[i].split(":")[0];
                            String mDesc= pModels[i].split(":")[1];
                            photos.add(new Photo(mUrl, mDesc));
                        }
                    }
                    return data;
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(String data) {
                if (data != null) {
                    try {
                        adapter = new CustomPhotoAdapter(MainActivity.this, photos);
                        gridView.setAdapter(adapter);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }.execute();
    }
}