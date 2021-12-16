package com.example.finalsubmit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.EmbossMaskFilter;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class secondActivity extends AppCompatActivity {
    ImageButton zoomin,zoomout,zoombright,zoomdark,zoomrotate,zoomgray,zoomblur,zoomemb;
    Button btnReset;
    MyGraphicView graphicView;
    static float scaleX=1,scaleY=1,angle=0,color=1,satur=1,res=1,aolor=1,amb=1,spec=1,blurR=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        setTitle("41730015 B반 김지호");


        LinearLayout pictureLayout=(LinearLayout)findViewById(R.id.pictureLayout);
        graphicView=(MyGraphicView)new MyGraphicView(this);
        pictureLayout.addView(graphicView);
        ImageView imageview = (ImageView)findViewById(R.id.ivPoster);
        clickIcons();

        Button btnReturn = (Button)findViewById(R.id.btnReturn);

        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent outIntent = new Intent(getApplicationContext(),MainActivity.class);
                setResult(RESULT_OK,outIntent);
                finish();
            }
        });

    }

    public void clickIcons() {
        zoomin=(ImageButton)findViewById(R.id.zoomin);
        zoomin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scaleX=scaleX+0.2f;
                scaleY=scaleY+0.2f;
                graphicView.invalidate();
            }
        });
        zoomout=(ImageButton)findViewById(R.id.zoomout);
        zoomout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scaleX=scaleX-0.2f;
                scaleY=scaleY-0.2f;
                graphicView.invalidate();
            }
        });
        zoomrotate=(ImageButton)findViewById(R.id.rotate);
        zoomrotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                angle=angle+20;
                graphicView.invalidate();
            }
        });
        zoombright=(ImageButton)findViewById(R.id.zoombright);
        zoombright.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                color=color+0.2f;
                graphicView.invalidate();
            }
        });
        zoomdark=(ImageButton)findViewById(R.id.zoomdark);
        zoomdark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                color=color-0.2f;
                graphicView.invalidate();
            }
        });
        zoomgray=(ImageButton)findViewById(R.id.zoomgray);
        zoomgray.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(satur==0)satur=1;
                else satur=0;
                graphicView.invalidate();
            }
        });
        zoomblur=(ImageButton) findViewById(R.id.zoomblur);
        zoomblur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                res = res + 3;
                graphicView.invalidate();
            }
        });
        btnReset=(Button) findViewById(R.id.btnReset);
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scaleX=1;
                scaleY=1;
                angle=0;
                color=1;
                satur=1;
                res=1;
                aolor=1;
                amb=1;
                spec=1;
                blurR=1;
                graphicView.invalidate();
            }
        });
//        zoomemb=(ImageButton) findViewById(R.id.zoomemb);
//        zoomemb.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                aolor = aolor + 1;
//                amb = amb + 0.5f;
//                spec = spec + 3;
//                blurR = blurR + 3;
//                graphicView.invalidate();
//            }
//        });
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
            float[] emArray = {aolor,aolor,aolor};
            ColorMatrix cm=new ColorMatrix(array);
            if(satur==0)cm.setSaturation(satur);
            BlurMaskFilter bMask = new BlurMaskFilter(res,BlurMaskFilter.Blur.NORMAL);
            paint.setColorFilter(new ColorMatrixColorFilter(cm));
            paint.setMaskFilter(bMask);
  //          EmbossMaskFilter eMask = new EmbossMaskFilter(emArray, amb,spec,blurR);
 //           paint.setMaskFilter(eMask);
            byte[] byteArray = getIntent().getByteArrayExtra("image");
            Bitmap picture = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
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
