package com.example.masterapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Registration extends AppCompatActivity {

    EditText reg_no
            , reg_name
            , reg_pwd
            , reg_email
            , reg_phone;
    DatePicker reg_dob;
    Spinner reg_state;
    Button btn_reg;
    Button btn_search;
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

        reg_no = findViewById(R.id.reg_no);
        reg_name = findViewById(R.id.reg_name);
        reg_pwd = findViewById(R.id.reg_pwd);
        reg_dob = findViewById(R.id.reg_dob);
        reg_email = findViewById(R.id.reg_email);
        reg_phone = findViewById(R.id.reg_phone);
        reg_state = findViewById(R.id.reg_state);
        btn_reg = findViewById(R.id.btn_registration);
        btn_search = findViewById(R.id.btn_search);

        regStateAdapter = ArrayAdapter.createFromResource(this, R.array.state_names, android.R.layout.simple_spinner_item);
        regStateAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        reg_state.setAdapter(regStateAdapter);

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, -18);
        long maxDateInMilliSec = calendar.getTimeInMillis();
        reg_dob.setMaxDate(maxDateInMilliSec);

        btn_reg.setOnClickListener(v -> {
            DatabaseHandler databaseHandler = new DatabaseHandler(Registration.this);

            if (reg_no != null && reg_name != null && reg_pwd != null && reg_email != null && reg_phone != null && reg_state.getSelectedItem() != "--STATE--") {
                int regNo = Integer.parseInt(String.valueOf(reg_no.getText()));
                String stuName = reg_name.getText().toString();
                String password = reg_pwd.getText().toString();
                String dob = reg_dob.getYear() + "-" + (reg_dob.getMonth() + 1) + "-" + reg_dob.getDayOfMonth();
                String email = reg_email.getText().toString();
                String phone = reg_phone.getText().toString();
                String state = reg_state.getSelectedItem().toString();

                databaseHandler.addStudentRegistration(
                        new StudentRegistration(regNo, stuName, password, dob, email, phone, state)
                );

                reg_no.setText(null);
                reg_name.setText(null);
                reg_pwd.setText(null);
                reg_email.setText(null);
                reg_phone.setText(null);
                reg_state.setSelection(0);

//            StringBuilder p = new StringBuilder();
//            for (int i = 0; i < password.length(); i++) {
//                p.append("*");
//            }

                Intent intentRegDetails = new Intent(Registration.this, RegistrationDetails.class);
                intentRegDetails.putExtra("regNo", String.valueOf(regNo));
                intentRegDetails.putExtra("stuName", stuName);
                intentRegDetails.putExtra("password", password);
                intentRegDetails.putExtra("dob", dob);
                intentRegDetails.putExtra("email", email);
                intentRegDetails.putExtra("phone", phone);
                intentRegDetails.putExtra("state", state);
                startActivity(intentRegDetails);

                Toast toastRecCreated = Toast.makeText(Registration.this, "Record Created", Toast.LENGTH_SHORT);
                toastRecCreated.show();
            } else {
                Toast.makeText(this, "Please enter all fields", Toast.LENGTH_SHORT).show();
            }

            databaseHandler.close();
        });

        btn_search.setOnClickListener(v -> {
            Intent intentRegSearch = new Intent(Registration.this, RegistrationSearch.class);
            startActivity(intentRegSearch);
//            Toast.makeText(this, "test", Toast.LENGTH_SHORT).show();
        });
    }
}