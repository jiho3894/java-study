package com.example.project11_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("41730015 B반 김지호");

        Gallery gallery = (Gallery) findViewById(R.id.gallery1);
        MyGalleryAdapter galAdapter = new MyGalleryAdapter(this);
        gallery.setAdapter(galAdapter);
    }

    public class MyGalleryAdapter extends BaseAdapter {
        Context context;
        Integer[] posterID = {
                R.drawable.mov1, R.drawable.mov2, R.drawable.mov3,
                R.drawable.mov4, R.drawable.mov5, R.drawable.mov6,
                R.drawable.mov7, R.drawable.mov8, R.drawable.mov9,
                R.drawable.mov10,
        };

        String[] posterName = {
                "백두산","2","기생충",
                "라라랜드","아이유","6",
                "1917", "코로나", "엑시트",
                "상치",
                "백두산","2","기생충",
                "라라랜드","아이유","6",
                "1917", "코로나", "엑시트",
                "상치",
                "백두산","2","기생충",
                "라라랜드","아이유","6",
                "1917", "코로나", "엑시트",
                "상치",
        };
        public MyGalleryAdapter(Context c) {
            context = c;
        }

        public int getCount() {
            return posterID.length;
        }
        public Object getItem(int arg0) {
            return null;
        }
        public long getItemId(int arg0) {
            return 0;
        }
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView = new ImageView(context);
            imageView.setLayoutParams(new Gallery.LayoutParams(200,300));
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setPadding(5,5,5,5);
            imageView.setImageResource(posterID[position]);

            final int pos = position;
            imageView.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    ImageView ivPoster = (ImageView) findViewById(R.id.ivPoster);
                    ivPoster.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    ivPoster.setImageResource(posterID[pos]);
                    Toast.makeText(getApplicationContext(), posterName[pos], Toast.LENGTH_SHORT).show();
                    return false;
                }
            });

            return imageView;
        }
    }
}