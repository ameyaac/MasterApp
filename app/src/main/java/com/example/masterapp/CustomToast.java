package com.example.masterapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CustomToast extends AppCompatActivity {

    Spinner spinner;
    LayoutInflater layoutInflater;
    View layout;
    Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_toast);

        spinner = findViewById(R.id.spinner);
        ArrayAdapter arrayAdapter = ArrayAdapter.createFromResource(this, R.array.bank_names, android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);

        layoutInflater = getLayoutInflater();

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 1:
                        layout = layoutInflater.inflate(R.layout.activity_hdfc, findViewById(R.id.hdfc_layout));
                        toast = new Toast(getApplicationContext());
                        toast.setDuration(Toast.LENGTH_SHORT);
                        toast.setView(layout);
                        toast.show();
                        break;

                    case 2:
                        layout = layoutInflater.inflate(R.layout.activity_icici, findViewById(R.id.icici_layout));
                        toast = new Toast(getApplicationContext());
                        toast.setDuration(Toast.LENGTH_SHORT);
                        toast.setView(layout);
                        toast.show();
                        break;

                    case 3:
                        layout = layoutInflater.inflate(R.layout.activity_sbi, findViewById(R.id.sbi_layout));
                        toast = new Toast(getApplicationContext());
                        toast.setDuration(Toast.LENGTH_SHORT);
                        toast.setView(layout);
                        toast.show();
                        break;

                    case 4:
                        layout = layoutInflater.inflate(R.layout.activity_axis, findViewById(R.id.axis_layout));
                        toast = new Toast(getApplicationContext());
                        toast.setDuration(Toast.LENGTH_SHORT);
                        toast.setView(layout);
                        toast.show();
                        break;

                    case 5:
                        layout = layoutInflater.inflate(R.layout.activity_kotak, findViewById(R.id.kotak_layout));
                        toast = new Toast(getApplicationContext());
                        toast.setDuration(Toast.LENGTH_SHORT);
                        toast.setView(layout);
                        toast.show();
                        break;

                    case 6:
                        layout = layoutInflater.inflate(R.layout.activity_pnb, findViewById(R.id.pnb_layout));
                        toast = new Toast(getApplicationContext());
                        toast.setDuration(Toast.LENGTH_SHORT);
                        toast.setView(layout);
                        toast.show();
                        break;

                    case 7:
                        layout = layoutInflater.inflate(R.layout.activity_iob, findViewById(R.id.iob_layout));
                        toast = new Toast(getApplicationContext());
                        toast.setDuration(Toast.LENGTH_SHORT);
                        toast.setView(layout);
                        toast.show();
                        break;

                    case 8:
                        layout = layoutInflater.inflate(R.layout.activity_indus, findViewById(R.id.indus_layout));
                        toast = new Toast(getApplicationContext());
                        toast.setDuration(Toast.LENGTH_SHORT);
                        toast.setView(layout);
                        toast.show();
                        break;

                    case 9:
                        layout = layoutInflater.inflate(R.layout.activity_union, findViewById(R.id.union_layout));
                        toast = new Toast(getApplicationContext());
                        toast.setDuration(Toast.LENGTH_SHORT);
                        toast.setView(layout);
                        toast.show();
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // Nothing Happens
            }
        });
    }
}