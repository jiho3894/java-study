# Java Study
package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edit1, edit2;
    Button btnAdd, btnSub, btnMul, btnDiv;
    TextView textResult;
    String num1, num2;
    Integer result;
    Button[] numButtons = new Button[10];
    Integer[] numBtnIDs = {R.id.BtnNum0, R.id.BtnNum1, R.id.BtnNum2, R.id.BtnNum3,
            R.id.BtnNum4, R.id.BtnNum5, R.id.BtnNum6,  R.id.BtnNum7,
            R.id.BtnNum8, R.id.BtnNum9};
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("테이블레이아웃 계산기");

        edit1 = (EditText) findViewById(R.id.Edit1);
        edit2 = (EditText) findViewById(R.id.Edit2);
        btnAdd = (Button) findViewById(R.id.BtnAdd);
        btnSub = (Button) findViewById(R.id.BtnSub);
        btnMul = (Button) findViewById(R.id.BtnMul);
        btnDiv = (Button) findViewById(R.id.BtnDiv);
        textResult = (TextView) findViewById(R.id.TextResult);

        btnAdd.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View arg0, MotionEvent arg1) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                result = Integer.parseInt(num1) + Integer.parseInt(num2);
                textResult.setText("계산결과:" + result.toString());
                return false;
            }
        });

        btnSub.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View arg0, MotionEvent arg1) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                result = Integer.parseInt(num1) - Integer.parseInt(num2);
                textResult.setText("계산결과:" + result.toString());
                return false;
            }
        });

        btnMul.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View arg0, MotionEvent arg1) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                result = Integer.parseInt(num1) * Integer.parseInt(num2);
                textResult.setText("계산결과:" + result.toString());
                return false;
            }
        });

        btnDiv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View arg0, MotionEvent arg1) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                result = Integer.parseInt(num1) / Integer.parseInt(num2);
                textResult.setText("계산결과:" + result.toString());
                return false;
            }
        });

        for(i=0; i<numBtnIDs.length; i++) {
            numButtons[i] = (Button) findViewById(numBtnIDs[i]);
        }

        for(i=0; i< numBtnIDs.length; i++) {
            final int index;
            index = i;

            numButtons[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (edit1.isFocused() == true) {
                        num1 = edit1.getText().toString() +
                                numButtons[index].getText().toString();
                        edit1.setText(num1);
                    } else if (edit1.isFocused() == true) {
                        num2 = edit2.getText().toString() +
                                numButtons[index].getText().toString();
                        edit2.setText(num2);
                    } else {
                        Toast.makeText(getApplicationContext(), "먼저 에디트텍스트를 선택하세요",
                                Toast.LENGTH_SHORT).show();
                    }

                }
            });
        }
    }
}










<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <TableLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        tools:layout_editor_absoluteX="184dp"
        tools:layout_editor_absoluteY="248dp">

        <TableRow>
            <EditText
                android:id="@+id/Edit1"
                android:layout_span="5"
                android:hint="숫자1 입력" />
        </TableRow>

        <TableRow>
            <EditText
                android:id="@+id/Edit2"
                android:layout_span="5"
                android:hint="숫자2 입력" />
        </TableRow>

        <TableRow>
            <Button
                android:id="@+id/BtnNum0"
                android:text="0" />

            <Button
                android:id="@+id/BtnNum1"
                android:text="1" />

            <Button
                android:id="@+id/BtnNum2"
                android:text="2" />

            <Button
                android:id="@+id/BtnNum3"
                android:text="3" />

            <Button
                android:id="@+id/BtnNum4"
                android:text="4" />
        </TableRow>

        <TableRow>
            <Button
                android:id="@+id/BtnNum5"
                android:text="5" />

            <Button
                android:id="@+id/BtnNum6"
                android:text="6" />

            <Button
                android:id="@+id/BtnNum7"
                android:text="7" />

            <Button
                android:id="@+id/BtnNum8"
                android:text="8" />

            <Button
                android:id="@+id/BtnNum9"
                android:text="9" />

        </TableRow>

        <TableRow>
            <Button
                android:id="@+id/BtnAdd"
                android:layout_margin="5dp"
                android:layout_span="5"
                android:text="더하기" />
        </TableRow>

        <TableRow>
            <Button
                android:id="@+id/BtnSub"
                android:layout_margin="5dp"
                android:layout_span="5"
                android:text="빼기" />
        </TableRow>

        <TableRow>
            <Button
                android:id="@+id/BtnMul"
                android:layout_margin="5dp"
                android:layout_span="5"
                android:text="곱하기" />
        </TableRow>

        <TableRow>
            <Button
                android:id="@+id/BtnDiv"
                android:layout_margin="5dp"
                android:layout_span="5"
                android:text="나누기" />
        </TableRow>

        <TableRow>
            <TextView
                android:id="@+id/TextResult"
                android:layout_margin="5dp"
                android:layout_span="5"
                android:text="계산 결과:"
                android:textColor="#FF0000"
                android:textSize="20dp"/>
        </TableRow>
    </TableLayout>

</androidx.constraintlayout.widget.ConstraintLayout>



<?xml version="1.0" encoding="utf-8"?>
<GridLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:columnCount="5"
    android:rowCount="9"
    app:flow_verticalGap="0px"
    tools:context=".MainActivity">

    <EditText
        android:id="@+id/Edit1"
        android:layout_width="181dp"
        android:layout_row="0"
        android:layout_column="0"
        android:layout_columnSpan="3"
        android:hint="숫자1 입력" />

    <EditText
        android:id="@+id/Edit2"
        android:layout_width="105dp"
        android:layout_row="2"
        android:layout_column="0"
        android:layout_span="5"
        android:hint="숫자2 입력" />

    <Button
        android:id="@+id/BtnNum0"
        android:layout_row="0"
        android:layout_column="0"
        android:text="0" />

    <Button
        android:id="@+id/BtnNum1"
        android:layout_row="3"
        android:layout_column="1"
        android:text="1" />

    <Button
        android:id="@+id/BtnNum2"
        android:layout_row="3"
        android:layout_column="2"
        android:text="2" />

    <Button
        android:id="@+id/BtnNum3"
        android:layout_row="3"
        android:layout_column="3"
        android:text="3" />

    <Button
        android:id="@+id/BtnNum4"
        android:layout_row="3"
        android:layout_column="4"
        android:text="4" />

    <Button
        android:id="@+id/BtnNum5"
        android:layout_row="4"
        android:layout_column="0"
        android:text="5" />

    <Button
        android:id="@+id/BtnNum6"
        android:layout_row="4"
        android:layout_column="1"
        android:text="6" />

    <Button
        android:id="@+id/BtnNum7"
        android:layout_row="4"
        android:layout_column="2"
        android:text="7" />

    <Button
        android:id="@+id/BtnNum8"
        android:layout_row="4"
        android:layout_column="3"
        android:text="8" />

    <Button
        android:id="@+id/BtnNum9"
        android:layout_row="4"
        android:layout_column="4"
        android:text="9" />

    <Button
        android:id="@+id/BtnAdd"
        android:layout_width="77dp"
        android:layout_row="5"
        android:layout_column="0"
        android:layout_columnSpan="3"
        android:layout_gravity="fill_horizontal"
        android:layout_margin="5dp"
        android:text="더하기" />

    <Button
        android:id="@+id/BtnSub"
        android:layout_row="6"
        android:layout_column="0"
        android:layout_margin="5dp"
        android:text="빼기" />

    <Button
        android:id="@+id/BtnMul"
        android:layout_row="7"
        android:layout_column="0"
        android:layout_margin="5dp"
        android:layout_span="5"
        android:text="곱하기" />

    <Button
        android:id="@+id/BtnDiv"
        android:layout_row="8"
        android:layout_column="0"
        android:layout_margin="5dp"
        android:layout_span="5"
        android:text="나누기" />

    <TextView
        android:id="@+id/TextResult"
        android:layout_row="9"
        android:layout_column="0"
        android:layout_margin="5dp"
        android:layout_span="5"
        android:text="계산 결과:"
        android:textColor="#FF0000"
        android:textSize="20dp" />
</GridLayout>




















