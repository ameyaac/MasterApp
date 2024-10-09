package com.example.masterapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RegistrationDetails extends AppCompatActivity {

    ListView reg_details;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registration_details);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setTitle("Registration Details");

        Intent intentRegDetails = getIntent();
        String regNo = intentRegDetails.getStringExtra("regNo");
        String stuName = intentRegDetails.getStringExtra("stuName");
        String password = intentRegDetails.getStringExtra("password");
        String dob = intentRegDetails.getStringExtra("dob");
        String email = intentRegDetails.getStringExtra("email");
        String phone = intentRegDetails.getStringExtra("phone");
        String state = intentRegDetails.getStringExtra("state");

        reg_details = findViewById(R.id.reg_details);

        List<String[]> data = new LinkedList<>();
        data.add(new String[]{regNo,"Registration Number"});
        data.add(new String[]{stuName,"Name"});
        data.add(new String[]{password,"Password"});
        data.add(new String[]{dob,"Date of Birth"});
        data.add(new String[]{email,"Email"});
        data.add(new String[]{phone,"Phone Number"});
        data.add(new String[]{state,"State"});

        ArrayAdapter<String[]> adapter = new ArrayAdapter<String[]>(this, android.R.layout.simple_list_item_2, android.R.id.text1, data) {
            @NonNull
            @Override
            public View getView(int position, View convertView, @NonNull ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                String[] entry = data.get(position);
                TextView text1 = view.findViewById(android.R.id.text1);
                TextView text2 = view.findViewById(android.R.id.text2);
                text1.setText(entry[0]);
                text2.setText(entry[1]);

                return view;
            }
        };
        reg_details.setAdapter(adapter);
    }
}