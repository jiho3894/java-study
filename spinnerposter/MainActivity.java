package com.example.porject11_4;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("41730015 B반 김지호");

        String[] posterName = {
                "백두산", "2", "기생충",
                "라라랜드", "아이유", "6",
                "1917", "코로나", "엑시트",
                "상치",
        };

        Integer[] posterID = {
                R.drawable.mov1, R.drawable.mov2, R.drawable.mov3,
                R.drawable.mov4, R.drawable.mov5, R.drawable.mov6,
                R.drawable.mov7, R.drawable.mov8, R.drawable.mov9,
                R.drawable.mov10,
        };

        Spinner spinner = (Spinner) findViewById(R.id.spinner1);
        ArrayAdapter<String> galAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, posterName);
        spinner.setAdapter(galAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ImageView ivPoster = (ImageView) findViewById(R.id.ivPoster);
                ivPoster.setScaleType(ImageView.ScaleType.FIT_CENTER);
                ivPoster.setImageResource(posterID[i]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    };
    }
