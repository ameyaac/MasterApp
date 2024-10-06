package com.example.masterapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.GridView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Gallery extends AppCompatActivity {

    GridView gallery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_gallery);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setTitle("Gallery");

        gallery = findViewById(R.id.prezGallery);
        gallery.setAdapter(new MyImageAdapter(this));

        gallery.setOnItemClickListener((adapterView, view, i, l) -> {
            Intent intentGallery = new Intent(this, GalleryImage.class);
            intentGallery.putExtra("position", i);
            startActivity(intentGallery);
        });
    }
}