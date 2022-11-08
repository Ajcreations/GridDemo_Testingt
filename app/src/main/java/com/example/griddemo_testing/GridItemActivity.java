package com.example.griddemo_testing;

import static com.example.griddemo_testing.R.id.griddata;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class GridItemActivity extends AppCompatActivity {

    TextView name;
    ImageView image;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_item);

        name = findViewById(R.id.griddata);
        image = findViewById(R.id.imageview);

        Intent intent = getIntent();
        name.setText(intent.getStringExtra("name"));
        image.setImageResource(intent.getIntExtra("image",0));
    }
}