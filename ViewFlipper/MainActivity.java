package com.example.viewflipper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {

    Button startBtn, stopBtn;
    ViewFlipper viewFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("41730015 B반 김지호");

        startBtn = (Button) findViewById(R.id.startBtn);
        stopBtn = (Button) findViewById(R.id.stopBtn);
        viewFlipper = (ViewFlipper) findViewById(R.id.viewFlipper);

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewFlipper.startFlipping();
                viewFlipper.setFlipInterval(1000);
            }
        });

        stopBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                viewFlipper.stopFlipping();
            }
        });
    }
}