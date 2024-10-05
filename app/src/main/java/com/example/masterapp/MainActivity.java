package com.example.masterapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btn_helloWorld
            , btn_toast
            , btn_lifeCycle
            , btn_sum
            , btn_form
            , btn_calc
            , btn_intent
            , btn_custToast
            , btn_menu;

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

        btn_helloWorld = findViewById(R.id.btn_welcome);
        btn_toast = findViewById(R.id.btn_toast);
        btn_lifeCycle = findViewById(R.id.btn_lifeCycle);
        btn_sum = findViewById(R.id.btn_sum);
        btn_form = findViewById(R.id.btn_form);
        btn_calc = findViewById(R.id.btn_calc);
        btn_intent = findViewById(R.id.btn_intent);
        btn_custToast = findViewById(R.id.btn_custToast);
        btn_menu = findViewById(R.id.btn_menu);

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
            case R.id.menu_president:
                Intent intentPresident = new Intent(MainActivity.this, President.class);
                startActivity(intentPresident);
        }
        return super.onOptionsItemSelected(item);
    }
}