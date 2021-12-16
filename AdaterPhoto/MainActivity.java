package com.example.test001;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

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

    private class MyGalleryAdapter extends BaseAdapter {
        Context context;
        Integer[] posterID = {
                R.drawable.mov1, R.drawable.mov3, R.drawable.mov5,
                R.drawable.mov1, R.drawable.mov3, R.drawable.mov5,
                R.drawable.mov1, R.drawable.mov3, R.drawable.mov5,
        };

        String[] posterName = {
                "백두산", "겟아웃" , "라라랜드",
                "백두산", "겟아웃" , "라라랜드",
                "백두산", "겟아웃" , "라라랜드"

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
            ImageView ivPoster = (ImageView) findViewById(R.id.ivPoster);

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

            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.iconLayout);
            ivPoster.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    final PopupMenu popupMenu = new PopupMenu(getApplicationContext(),view);
                    getMenuInflater().inflate(R.menu.popup,popupMenu.getMenu());
                    popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem menuItem) {
                            if (menuItem.getItemId() == R.id.action_menu1){
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
                            return false;
                        }
                    });
                    popupMenu.show();
                }
            });
            return imageView;
        }
    }
}

