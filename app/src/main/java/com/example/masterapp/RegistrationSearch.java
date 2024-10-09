package com.example.masterapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;

public class RegistrationSearch extends AppCompatActivity {

    EditText sreg_no
            , sreg_name
            , sreg_pwd
            , sreg_dob
            , sreg_email
            , sreg_phone;
    Spinner sreg_state;
    Button btn_search
            , btn_edit
            , btn_delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registration_search);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        sreg_no = findViewById(R.id.search_reg_no);
        sreg_name = findViewById(R.id.search_reg_name);
        sreg_pwd = findViewById(R.id.search_reg_pwd);
        sreg_dob = findViewById(R.id.search_reg_dob);
        sreg_email = findViewById(R.id.search_reg_email);
        sreg_phone = findViewById(R.id.search_reg_phone);
        sreg_state = findViewById(R.id.search_reg_state);
        btn_search = findViewById(R.id.btn_search);

        DatabaseHandler handler = new DatabaseHandler(this);
        int regNo = Integer.parseInt(sreg_no.getText().toString());
        StudentRegistration registration = handler.getStudentRegistration(regNo);

        btn_search.setOnClickListener(v -> {
            sreg_name.setVisibility(View.VISIBLE);
            sreg_name.setText(registration.get_stu_name());
            sreg_pwd.setVisibility(View.VISIBLE);
            sreg_pwd.setText(registration.get_pwd());
            sreg_dob.setVisibility(View.VISIBLE);
            sreg_dob.setText(registration.get_dob());
            sreg_email.setVisibility(View.VISIBLE);
            sreg_email.setText(registration.get_email());
            sreg_phone.setVisibility(View.VISIBLE);
            sreg_phone.setText(registration.get_ph_no());
            sreg_state.setVisibility(View.VISIBLE);
            String[] states = getResources().getStringArray(R.array.state_names);
            int pos = Arrays.asList(states).indexOf(registration.get_state());
            sreg_state.setSelection(pos);
            btn_search.setVisibility(View.GONE);
            btn_edit.setVisibility(View.VISIBLE);
            btn_delete.setVisibility(View.VISIBLE);
        });

        handler.close();
    }
}