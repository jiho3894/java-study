package com.example.project9_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    ImageButton ibZoomin, ibZoomout, ibRotate, ibBright, ibDrak, ibGray;
    MyGraphicView graphicView;

    static float scaleX=1, scaleY=1;
    static float angle=0;
    static float color=1;
    static float satur=1;
    static float bmask=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("41730015 B반 김지호");

        LinearLayout pictureLayout = (LinearLayout) findViewById(R.id.pictureLayout);
        graphicView = (MyGraphicView) new  MyGraphicView(this);
        pictureLayout.addView(graphicView);
        clickIcons();
    }

    public void clickIcons() {
        ibZoomin=(ImageButton)findViewById(R.id.ibZoomin);
        ibZoomin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scaleX=scaleX+0.2f;
                scaleY=scaleY+0.2f;
                graphicView.invalidate();
            }
        });
        ibZoomout=(ImageButton)findViewById(R.id.ibZoomout);
        ibZoomout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scaleX=scaleX-0.2f;
                scaleY=scaleY-0.2f;
                graphicView.invalidate();
            }
        });
        ibRotate=(ImageButton)findViewById(R.id.ibRotate);
        ibRotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                angle=angle+20;
                graphicView.invalidate();
            }
        });
        ibBright=(ImageButton)findViewById(R.id.ibBright);
        ibBright.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                color=color+0.2f;
                graphicView.invalidate();
            }
        });
        ibDrak=(ImageButton)findViewById(R.id.ibDark);
        ibDrak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                color=color-0.2f;
                graphicView.invalidate();
            }
        });
    }


    private class MyGraphicView extends View {
        public MyGraphicView(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            Paint paint=new Paint();
            float[] array={color,0,0,0,0,
                    0,color,0,0,0,
                    0,0,color,0,0,
                    0,0,0,1,0};
            ColorMatrix cm=new ColorMatrix(array);
            if(satur==0)cm.setSaturation(satur);// 위치 여기다가!!
            paint.setColorFilter(new ColorMatrixColorFilter(cm));

            Bitmap picture= BitmapFactory.decodeResource(getResources(),R.drawable.ap01);
            int picX=(this.getWidth()-picture.getWidth())/2;
            int picY=(this.getHeight()-picture.getHeight())/2;
            int cenX=this.getWidth()/2;
            int cenY=this.getHeight()/2;
            canvas.scale(scaleX,scaleY,cenX,cenY);
            canvas.rotate(angle,cenX,cenY);
            canvas.drawBitmap(picture,picX,picY,paint);
            picture.recycle();
        }
    }
}