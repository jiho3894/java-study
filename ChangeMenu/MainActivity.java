package com.example.changemenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    EditText edit1;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("41730015 B반 김지호");
        edit1 = (EditText) findViewById(R.id.edit1);
        img = (ImageView) findViewById(R.id.imgView);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.subRotate:
                img.setRotation(Integer.parseInt(edit1.getText().toString()));
                break;
            case R.id.item1:
                item.setChecked(true);
                img.setImageResource(R.drawable.rabbit);
                img.setVisibility(View.VISIBLE);
                break;
            case R.id.item2:
                item.setChecked(true);
                img.setImageResource(R.drawable.cat);
                img.setVisibility(View.VISIBLE);
                break;

            case R.id.item3:
                item.setChecked(true);
                img.setImageResource(R.drawable.dog);
                img.setVisibility(View.VISIBLE);
                break;

        }
        return true;
    }
}