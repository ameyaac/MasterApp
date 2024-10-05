package com.example.masterapp;

import android.annotation.SuppressLint;
import android.app.FragmentContainer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class President extends AppCompatActivity {

    int fragmentContainer;
    Fragment prezList, prezDisp;
    Button btn_prezList, btn_prezDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_president);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        fragmentContainer = R.id.fragmentContainerView;

        prezDisp = new Fragment(R.layout.fragment_president_details);
        prezList = new Fragment(R.layout.fragment_president_list);

        btn_prezList = findViewById(R.id.btn_prez_list);
        btn_prezDetails = findViewById(R.id.btn_prez_details);

        loadFragment(prezList);

        btn_prezDetails.setOnClickListener(v -> {
            loadFragment(prezDisp);
        });

        btn_prezList.setOnClickListener(v -> {
            loadFragment(prezList);
        });

    }

    public void loadFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(fragmentContainer, fragment);
        fragmentTransaction.commit();
    }
}