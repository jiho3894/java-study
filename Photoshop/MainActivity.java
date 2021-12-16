package com.example.finalsubmit;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

public class MainActivity extends AppCompatActivity {

    private Button btnNewActivity;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("41730015 B반 김지호");


        final GridView gv = (GridView) findViewById(R.id.gridView1);
        MyGridAdapter gAdapter = new MyGridAdapter(this);
        gv.setAdapter(gAdapter);
    }

    public class MyGridAdapter extends BaseAdapter {
        Context context;
        public MyGridAdapter(Context c) {
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

        Integer[] posterID = {
                R.drawable.mov1, R.drawable.mov3, R.drawable.mov5,
                R.drawable.mov1, R.drawable.mov3, R.drawable.mov5,
                R.drawable.mov1, R.drawable.mov3, R.drawable.mov5,
                R.drawable.mov1, R.drawable.mov3, R.drawable.mov5,
                R.drawable.mov1, R.drawable.mov3, R.drawable.mov5,
                R.drawable.mov1, R.drawable.mov3, R.drawable.mov5
        };

        String[] posterName = {
                "백두산", "겟아웃" , "라라랜드",
                "백두산", "겟아웃" , "라라랜드",
                "백두산", "겟아웃" , "라라랜드",
                "백두산", "겟아웃" , "라라랜드",
                "백두산", "겟아웃" , "라라랜드",
                "백두산", "겟아웃" , "라라랜드"

        };
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView = new ImageView(context);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(300,400));
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setPadding(5,5,5,5);

            imageView.setImageResource(posterID[position]);
            final int pos = position;
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    View dialogView = (View) View.inflate(MainActivity.this,R.layout.dialog, null);
                    AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                    ImageView ivPoster = (ImageView) dialogView.findViewById(R.id.ivPoster);
                    ivPoster.setImageResource(posterID[pos]);
                    dlg.setTitle(posterName[pos]);
                    dlg.setView(dialogView);
                    dlg.setNegativeButton("닫기", null);
                    dlg.show();
                    btnNewActivity = (Button) dialogView.findViewById(R.id.btnNewActivity);
                    btnNewActivity.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            ByteArrayOutputStream stream = new ByteArrayOutputStream();
                            Bitmap bitmap = ((BitmapDrawable)ivPoster.getDrawable()).getBitmap();
                            float scale = (float) (1024/(float)bitmap.getWidth());
                            int image_w = (int) (bitmap.getWidth() * scale);
                            int image_h = (int) (bitmap.getHeight() * scale);
                            Bitmap resize = Bitmap.createScaledBitmap(bitmap, image_w, image_h, true);
                            resize.compress(Bitmap.CompressFormat.JPEG, 100, stream);
                            byte[] byteArray = stream.toByteArray();

                            Intent intent = new Intent(MainActivity.this, secondActivity.class);

                            intent.putExtra("image", byteArray);

                            startActivity(intent);

                        }

                    });
                }
            });

            return imageView;
        }
    }
}