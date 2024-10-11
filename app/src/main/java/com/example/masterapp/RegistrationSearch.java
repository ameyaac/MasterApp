package com.example.masterapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.ActionBar;
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
    Button btn_ssearch
            , btn_edit
            , btn_delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registration_search);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setTitle("Search");

        sreg_no = findViewById(R.id.search_reg_no);
        sreg_name = findViewById(R.id.search_reg_name);
        sreg_pwd = findViewById(R.id.search_reg_pwd);
        sreg_dob = findViewById(R.id.search_reg_dob);
        sreg_email = findViewById(R.id.search_reg_email);
        sreg_phone = findViewById(R.id.search_reg_phone);
        sreg_state = findViewById(R.id.search_reg_state);
        btn_ssearch = findViewById(R.id.btn_ssearch);
        btn_edit = findViewById(R.id.btn_edit);
        btn_delete = findViewById(R.id.btn_delete);

        ArrayAdapter<CharSequence> regStateAdapter;
        regStateAdapter = ArrayAdapter.createFromResource(this, R.array.state_names, android.R.layout.simple_spinner_item);
        regStateAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sreg_state.setAdapter(regStateAdapter);

        DatabaseHandler handler = new DatabaseHandler(RegistrationSearch.this);

        btn_ssearch.setOnClickListener(v -> {
            String regNoStr = sreg_no.getText().toString();

            // Validate if the registration number is provided
            if (regNoStr.isEmpty()) {
                Toast.makeText(this, "Please enter a registration number", Toast.LENGTH_SHORT).show();
                return;
            }

            int regNo = Integer.parseInt(regNoStr);
            StudentRegistration registration = handler.getStudentRegistration(regNo);

            if (registration != null) {
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
                if (pos >= 0) {
                    sreg_state.setSelection(pos);
                }
                btn_ssearch.setVisibility(View.GONE);
                btn_edit.setVisibility(View.VISIBLE);
                btn_delete.setVisibility(View.VISIBLE);
            } else {
                Toast.makeText(this, "No record found", Toast.LENGTH_SHORT).show();
            }
        });

        btn_edit.setOnClickListener(v -> {
            String regNoStr = sreg_no.getText().toString();
            if (regNoStr.isEmpty()) {
                Toast.makeText(this, "Please enter a registration number", Toast.LENGTH_SHORT).show();
                return;
            }

            int regNo = Integer.parseInt(regNoStr);
            StudentRegistration registration = handler.getStudentRegistration(regNo);

            if (registration != null) {
                registration.set_stu_name(sreg_name.getText().toString());
                registration.set_pwd(sreg_pwd.getText().toString());
                registration.set_dob(sreg_dob.getText().toString());
                registration.set_email(sreg_email.getText().toString());
                registration.set_ph_no(sreg_phone.getText().toString());
                registration.set_state(sreg_state.getSelectedItem().toString());

                handler.updateStudentRegistration(registration);

                Toast.makeText(this, "Details edited successfully", Toast.LENGTH_SHORT).show();
                finish();  // Close current activity to prevent redundant stacks
            } else {
                Toast.makeText(this, "No registration found", Toast.LENGTH_SHORT).show();
            }
        });

        btn_delete.setOnClickListener(v -> {
            String regNoStr = sreg_no.getText().toString();
            if (regNoStr.isEmpty()) {
                Toast.makeText(this, "Please enter a registration number", Toast.LENGTH_SHORT).show();
                return;
            }

            int regNo = Integer.parseInt(regNoStr);
            StudentRegistration registration = handler.getStudentRegistration(regNo);

            if (registration != null) {
                handler.deleteStudentRegistration(registration);

                Toast.makeText(this, "Details deleted successfully", Toast.LENGTH_SHORT).show();
                clearFields();  // Clear input fields after delete

                // Navigate to registration activity and finish current one
                startActivity(new Intent(this, Registration.class));
                finish();
            } else {
                Toast.makeText(getApplicationContext(), "No registration found", Toast.LENGTH_SHORT).show();
            }
        });

        handler.close();
    }

    private void clearFields() {
        sreg_no.setText(null);
        sreg_name.setText(null);
        sreg_pwd.setText(null);
        sreg_dob.setText(null);
        sreg_email.setText(null);
        sreg_phone.setText(null);
        sreg_state.setSelection(0);
        btn_edit.setVisibility(View.GONE);
        btn_delete.setVisibility(View.GONE);
        btn_ssearch.setVisibility(View.VISIBLE);
    }
}