package com.example.masterapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class Sum extends AppCompatActivity {

    EditText field1, field2;
    Button buttonAdd, buttonReset;
    TextView result;
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sum);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setTitle("Sum");

        field1 = findViewById(R.id.editTextNumberDecimal1);
        field2 = findViewById(R.id.editTextNumberDecimal2);
        buttonAdd = findViewById(R.id.add);
        buttonReset = findViewById(R.id.reset);
        result = findViewById(R.id.result);

        buttonAdd.setOnClickListener(v -> {
            String s1 = field1.getText().toString();
            String s2 = field2.getText().toString();
            if (s1.isEmpty() || s2.isEmpty()) {
                Toast.makeText(this, "Please enter both numbers", Toast.LENGTH_SHORT).show();
                return;
            }
            Double num1 = Double.parseDouble(s1);
            Double num2 = Double.parseDouble(s2);
            Double sum = num1 + num2;
            result.setText(String.valueOf(sum));
            Toast.makeText(this, "Result: " + sum, Toast.LENGTH_SHORT).show();
        });

        buttonReset.setOnClickListener(v -> {
            field1.setText("");
            field2.setText("");
            result.setText(R.string.RESULT);
            Toast.makeText(this, "Reset successful", Toast.LENGTH_SHORT).show();
        });
    }
}