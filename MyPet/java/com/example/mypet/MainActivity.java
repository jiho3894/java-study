package com.example.mypet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView text1, text2;
    Switch sw;
    RadioGroup rGroup1;
    RadioButton rdoDog, rdoCat, rdoRabbit;
    Button btnEsc, btnReset;
    ImageView imgPet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("B반 41730015 김지호");

        text1 = (TextView) findViewById(R.id.Text1);
        sw = (Switch) findViewById(R.id.switch1);

        text2 = (TextView) findViewById(R.id.Text2);

        rGroup1 = (RadioGroup) findViewById(R.id.Rgroup1);
        rdoDog = (RadioButton) findViewById(R.id.RdoDog);
        rdoCat = (RadioButton) findViewById(R.id.RdoCat);
        rdoRabbit = (RadioButton) findViewById(R.id.RdoRabbit);
        imgPet = (ImageView) findViewById(R.id.ImgPet);

        btnEsc = (Button) findViewById(R.id.BtnEsc);
        btnReset = (Button) findViewById(R.id.BtnReset);

        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(sw.isChecked() == true) {
                    text2.setVisibility(View.VISIBLE);
                    rGroup1.setVisibility(View.VISIBLE);
                    imgPet.setVisibility(View.VISIBLE);
                } else {
                    text2.setVisibility(View.INVISIBLE);
                    rGroup1.setVisibility(View.INVISIBLE);
                    imgPet.setVisibility(View.INVISIBLE);
                }
            }
        });

        rdoDog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (rGroup1.getCheckedRadioButtonId()) {
                    case R.id.RdoDog:
                        imgPet.setImageResource(R.drawable.pi);
                        break;
                    default:
                        Toast.makeText(getApplicationContext(), "동물을 먼저 선택하세요" , Toast.LENGTH_SHORT).show();
                }
            }
        });

        rdoCat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (rGroup1.getCheckedRadioButtonId()) {
                    case R.id.RdoCat:
                        imgPet.setImageResource(R.drawable.cat);
                        break;
                    default:
                        Toast.makeText(getApplicationContext(), "동물을 먼저 선택하세요" , Toast.LENGTH_SHORT).show();
                }
            }
        });

        rdoRabbit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (rGroup1.getCheckedRadioButtonId()) {
                    case R.id.RdoRabbit:
                        imgPet.setImageResource(R.drawable.rabbit);
                        break;
                    default:
                        Toast.makeText(getApplicationContext(), "동물을 먼저 선택하세요" , Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnEsc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sw.setChecked(false);
                rdoDog.setChecked(false);
                rdoCat.setChecked(false);
                rdoRabbit.setChecked(false);
                imgPet.setImageResource(0);
            }
        });
    }
}