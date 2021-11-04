package com.example.project8_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    Button btnPrev, btnNext;
    myPictureView myPicture;
    int curNum = 1;
    File[] imageFiles;
    String imageFrame;
    TextView textView1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("41730015 B반 김지호");
        ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, MODE_PRIVATE);

        btnPrev = (Button) findViewById(R.id.btnPrev);
        btnNext = (Button) findViewById(R.id.btnNext);
        myPicture = (myPictureView) findViewById(R.id.myPictureView1);
        textView1 = (TextView) findViewById(R.id.textview1);

        imageFiles = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Pictures").listFiles();
        imageFrame = imageFiles[1].toString();
        myPicture.imagePath = imageFrame;

        btnPrev.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (curNum <= 1) {
                    curNum = imageFiles.length;
                    //Toast.makeText(getApplicationContext(),"첫번쨰 그립입니다.",Toast.LENGTH_SHORT).show();
                } else {
                    curNum--;
                }
                imageFrame = imageFiles[curNum - 1].toString();
                myPicture.imagePath = imageFrame;
                myPicture.invalidate();
                textView1.setText(String.valueOf(curNum) + "/" + String.valueOf(imageFiles.length));
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (curNum >= imageFiles.length) {
                    curNum = 1;
                    imageFrame = imageFiles[curNum - 1].toString();
                    myPicture.imagePath = imageFrame;
                    myPicture.invalidate();
                    textView1.setText(String.valueOf(curNum) + "/" + String.valueOf(imageFiles.length));
                    //Toast.makeText(getApplicationContext(),"마지막 그림입니다.",Toast.LENGTH_SHORT).show();
                } else {
                    curNum++;
                    imageFrame = imageFiles[curNum - 1].toString();
                    myPicture.imagePath = imageFrame;
                    myPicture.invalidate();
                }
                textView1.setText(String.valueOf(curNum) + "/" + String.valueOf(imageFiles.length));
            }
        });
    }
}