package com.example.masterapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DateTime extends AppCompatActivity {

    DatePicker datePicker;
    TimePicker timePicker;
    TextView textView;
    Button btn_ok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_date_time);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setTitle("Date and Time");

        datePicker = findViewById(R.id.datePicker);
        timePicker = findViewById(R.id.timePicker);
        textView = findViewById(R.id.txt_dateTime);
        btn_ok = findViewById(R.id.btn_ok);

//        timePicker.setIs24HourView(true);

        btn_ok.setOnClickListener(v -> {
            textView.setText("\nDate: " + date() + "\nTime: " + time());
        });
    }

    private String date() {
        StringBuilder sb = new StringBuilder();
        sb.append(datePicker.getYear()).append("-");
        sb.append(datePicker.getMonth() + 1).append("-");
        sb.append(datePicker.getDayOfMonth());

        return sb.toString();
    }

    private String time() {
        StringBuilder sb = new StringBuilder();
        sb.append((timePicker.getHour() < 12) ? (timePicker.getHour()) : (timePicker.getHour() - 12))
                .append(":")
                .append((timePicker.getMinute() < 10) ? ("0"+timePicker.getMinute()) : (timePicker.getMinute()))
                .append(" ")
                .append((timePicker.getHour() < 12) ? "AM" : "PM");

        return sb.toString();
    }
}