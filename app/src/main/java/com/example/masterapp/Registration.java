package com.example.masterapp;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Registration extends AppCompatActivity {

    EditText reg_name
            , reg_pwd
            , reg_email
            , reg_phone;
    DatePicker reg_dob;
    Spinner reg_state;
    ArrayAdapter<CharSequence> regStateAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registration);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setTitle("Registration");

        reg_name = findViewById(R.id.reg_name);
        reg_pwd = findViewById(R.id.reg_pwd);
        reg_dob = findViewById(R.id.reg_dob);
        reg_email = findViewById(R.id.reg_email);
        reg_phone = findViewById(R.id.reg_phone);
        reg_state = findViewById(R.id.reg_state);

        regStateAdapter = ArrayAdapter.createFromResource(this, R.array.state_names, android.R.layout.simple_spinner_item);
        regStateAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        reg_state.setAdapter(regStateAdapter);

    }
}