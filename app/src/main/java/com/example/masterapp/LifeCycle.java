package com.example.masterapp;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class LifeCycle extends AppCompatActivity {

    TextView logtext;
    String text, time;
    SimpleDateFormat dateTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_life_cycle);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setTitle(R.string.lifeCycleLog);

        logtext = findViewById(R.id.txt_log);
    }

    @Override
    protected void onStart() {
        super.onStart();
        text = logtext.getText().toString();
        dateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        time = dateTime.format(new Date());
        text += time + "\tStarted\n";
        logtext.setText(text);
    }

    @Override
    protected void onResume() {
        super.onResume();
        text = logtext.getText().toString();
        dateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        time = dateTime.format(new Date());
        text += time + "\tResumed\n";
        logtext.setText(text);
    }

    @Override
    protected void onPause() {
        super.onPause();
        dateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        time = dateTime.format(new Date());
        text += time + "\tPaused\n";
        logtext.setText(text);
    }

    @Override
    protected void onStop() {
        super.onStop();
        text = logtext.getText().toString();
        dateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        time = dateTime.format(new Date());
        text += time + "\tStopped\n";
        logtext.setText(text);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        text = logtext.getText().toString();
        dateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        time = dateTime.format(new Date());
        text += time + "\tRestarted\n";
        logtext.setText(text);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        text = logtext.getText().toString();
        dateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        time = dateTime.format(new Date());
        text += time + "\tDestroyed\n";
        logtext.setText(text);
    }
}