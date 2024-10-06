package com.example.masterapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class MainActivity extends AppCompatActivity {

    Button btn_helloWorld
            , btn_toast
            , btn_lifeCycle
            , btn_sum
            , btn_form
            , btn_calc
            , btn_intent
            , btn_custToast
            , btn_menu
            , btn_dateTime
            , btn_progress;
    FloatingActionButton btn_float;
    ProgressBar progressBar;
    private int progressBarStatus;
    private long fileSize;

    private final Handler progressBarHandler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        progressBar = findViewById(R.id.progressBar);

        btn_helloWorld = findViewById(R.id.btn_welcome);
        btn_toast = findViewById(R.id.btn_toast);
        btn_lifeCycle = findViewById(R.id.btn_lifeCycle);
        btn_sum = findViewById(R.id.btn_sum);
        btn_form = findViewById(R.id.btn_form);
        btn_calc = findViewById(R.id.btn_calc);
        btn_intent = findViewById(R.id.btn_intent);
        btn_custToast = findViewById(R.id.btn_custToast);
        btn_menu = findViewById(R.id.btn_menu);
        btn_dateTime = findViewById(R.id.btn_dateTime);
        btn_progress = findViewById(R.id.btn_progress);

        btn_float = findViewById(R.id.btn_floating);

        btn_helloWorld.setOnClickListener(v -> {
                Intent intentHelloWorld = new Intent(MainActivity.this, HelloWorld.class);
                startActivity(intentHelloWorld);
        });

        btn_toast.setOnClickListener(v -> {
                Toast homeToast = Toast.makeText(getApplicationContext(), "This is Toast 🍞", Toast.LENGTH_LONG);
                homeToast.show();
        });

        btn_lifeCycle.setOnClickListener(v -> {
                Intent intentLifeCycle = new Intent(MainActivity.this, LifeCycle.class);
                startActivity(intentLifeCycle);
        });

        btn_sum.setOnClickListener(v -> {
            Intent intentSum = new Intent(MainActivity.this, Sum.class);
            startActivity(intentSum);
        });

        btn_form.setOnClickListener(v -> {
            Intent intentForm = new Intent(MainActivity.this, Form.class);
            startActivity(intentForm);
        });

        btn_calc.setOnClickListener(v -> {
            Intent intentCalc = new Intent(MainActivity.this, Calculator.class);
            startActivity(intentCalc);
        });

        btn_intent.setOnClickListener(v -> {
            Intent intentIntent = new Intent(MainActivity.this, IntentMain.class);
            startActivity(intentIntent);
        });

        btn_custToast.setOnClickListener(v -> {
            Intent intentCustToast = new Intent(MainActivity.this, CustomToast.class);
            startActivity(intentCustToast);
        });

        btn_menu.setOnClickListener(v -> {
            Toast menuToast = Toast.makeText(getApplicationContext(), "Please click on the three dot menu on the top right", Toast.LENGTH_LONG);
            menuToast.show();
        });

        btn_dateTime.setOnClickListener(v -> {
            Intent intentDateTime = new Intent(MainActivity.this, DateTime.class);
            startActivity(intentDateTime);
        });

        btn_float.setOnClickListener(v -> {
            Toast floatBtnToast = Toast.makeText(getApplicationContext(), "Floating Button", Toast.LENGTH_LONG);
            floatBtnToast.show();
        });

        btn_progress.setOnClickListener(v -> {
            progressBar.setVisibility(View.VISIBLE);
            progressBarStatus = 0;

            new Thread(() -> {
                while(progressBarStatus < 100) {
                    progressBarStatus += ThreadLocalRandom.current().nextInt(20);
                    try {
                        Thread.sleep(ThreadLocalRandom.current().nextInt(2000));
                    } catch (InterruptedException ie) {
                        Log.d("Thread", "Thread Interrupted");
                    }
                    progressBarHandler.post(() -> progressBar.setProgress(progressBarStatus));
                }
                progressBarHandler.post(() -> {
                    progressBar.setVisibility(View.GONE);
                    Toast.makeText(MainActivity.this, "Task Completed", Toast.LENGTH_SHORT).show();
                });
            }).start();
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int choice = item.getItemId();
        switch (choice) {
            case R.id.menu_toast:
                Toast menuToast = Toast.makeText(getApplicationContext(), "This is Toast 🍞", Toast.LENGTH_LONG);
                menuToast.show();
                break;
            case R.id.menu_exit:
                MainActivity.this.finish();
                System.exit(0);
            case R.id.menu_president_list:
                Intent intentPresidentList = new Intent(MainActivity.this, President.class);
                startActivity(intentPresidentList);
                break;
            case R.id.menu_president_gallary:
                Intent intentPresidentGallery = new Intent(MainActivity.this, Gallery.class);
                startActivity(intentPresidentGallery);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}