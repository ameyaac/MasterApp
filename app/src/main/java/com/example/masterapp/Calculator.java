package com.example.masterapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.button.MaterialButton;

public class Calculator extends AppCompatActivity {

    TextView resultTv, solutionTv;
    MaterialButton btnC, btnAC;
    MaterialButton btnDiv, btnMul, btnAdd, btnSub, btnPercent, btnEqual;
    MaterialButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btn00;
    MaterialButton btnPoint;
    float num1, num2, result;
    boolean add, sub, mul, div, per;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setTitle("Calculator");

        resultTv = findViewById(R.id.result_tv);
        solutionTv = findViewById(R.id.solution_tv);

        btn1 = findViewById(R.id.button_one);
        btn2 = findViewById(R.id.button_two);
        btn3 = findViewById(R.id.button_three);
        btn4 = findViewById(R.id.button_four);
        btn5 = findViewById(R.id.button_five);
        btn6 = findViewById(R.id.button_six);
        btn7 = findViewById(R.id.button_seven);
        btn8 = findViewById(R.id.button_eight);
        btn9 = findViewById(R.id.button_nine);
        btn0 = findViewById(R.id.button_zero);
        btn00 = findViewById(R.id.button_zzero);
        btnAdd = findViewById(R.id.button_add);
        btnSub = findViewById(R.id.button_minus);
        btnMul = findViewById(R.id.button_multiple);
        btnDiv = findViewById(R.id.button_divide);
        btnPoint = findViewById(R.id.button_point);
        btnPercent = findViewById(R.id.button_percent);
        btnC = findViewById(R.id.button_c);
        btnAC = findViewById(R.id.button_ac);
        btnEqual = findViewById(R.id.button_equal);

        btnC.setOnClickListener(view -> {
            solutionTv.setText("");
            resultTv.setText("");
        });

        btnAC.setOnClickListener(view -> {
            solutionTv.setText("");
            resultTv.setText("");
        });

        btn00.setOnClickListener(view -> solutionTv.setText(solutionTv.getText() + "00"));
        btn0.setOnClickListener(view -> solutionTv.setText(solutionTv.getText() + "0"));
        btn1.setOnClickListener(view -> solutionTv.setText(solutionTv.getText() + "1"));
        btn2.setOnClickListener(view -> solutionTv.setText(solutionTv.getText() + "2"));
        btn3.setOnClickListener(view -> solutionTv.setText(solutionTv.getText() + "3"));
        btn4.setOnClickListener(view -> solutionTv.setText(solutionTv.getText() + "4"));
        btn5.setOnClickListener(view -> solutionTv.setText(solutionTv.getText() + "5"));
        btn6.setOnClickListener(view -> solutionTv.setText(solutionTv.getText() + "6"));
        btn7.setOnClickListener(view -> solutionTv.setText(solutionTv.getText() + "7"));
        btn8.setOnClickListener(view -> solutionTv.setText(solutionTv.getText() + "8"));
        btn9.setOnClickListener(view -> solutionTv.setText(solutionTv.getText() + "9"));
        btnPoint.setOnClickListener(view -> solutionTv.setText(solutionTv.getText() + "."));

        btnAdd.setOnClickListener(view -> {
            if (!solutionTv.getText().toString().isEmpty()) {
                num1 = Float.parseFloat(solutionTv.getText().toString());
                solutionTv.setText("");
                add = true;
            }
        });

        btnSub.setOnClickListener(view -> {
            if (!solutionTv.getText().toString().isEmpty()) {
                num1 = Float.parseFloat(solutionTv.getText().toString());
                solutionTv.setText("");
                sub = true;
            }
        });

        btnMul.setOnClickListener(view -> {
            if (!solutionTv.getText().toString().isEmpty()) {
                num1 = Float.parseFloat(solutionTv.getText().toString());
                solutionTv.setText("");
                mul = true;
            }
        });

        btnDiv.setOnClickListener(view -> {
            if (!solutionTv.getText().toString().isEmpty()) {
                num1 = Float.parseFloat(solutionTv.getText().toString());
                solutionTv.setText("");
                div = true;
            }
        });

        btnPercent.setOnClickListener(view -> {
            if (!solutionTv.getText().toString().isEmpty()) {
                num1 = Float.parseFloat(solutionTv.getText().toString());
                solutionTv.setText("");
                per = true;
            }
        });

        btnEqual.setOnClickListener(view -> {
            if (!solutionTv.getText().toString().isEmpty()) {
                num2 = Float.parseFloat(solutionTv.getText().toString());

                if (add) {
                    result = num1 + num2;
                    add = false;
                } else if (sub) {
                    result = num1 - num2;
                    sub = false;
                } else if (mul) {
                    result = num1 * num2;
                    mul = false;
                } else if (div) {
                    result = num1 / num2;
                    div = false;
                } else if (per) {
                    result = (num1 * num2) / 100;
                    per = false;
                }
                resultTv.setText(String.valueOf(result));
            }
        });
    }
}