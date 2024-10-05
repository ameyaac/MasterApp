package com.example.masterapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
//import android.text.TextWatcher;
//import android.text.Editable;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

public class IntentMain extends AppCompatActivity {

    ToggleButton tb, tb2;
    EditText et;
    Button btn;
    Intent display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_main);

        tb = findViewById(R.id.toggleButton);
        tb2 = findViewById(R.id.toggleButton2);
        et = findViewById(R.id.editTextText);
        btn = findViewById(R.id.Button);
        display = new Intent(IntentMain.this, IntentDisplay.class);

        et.setText("WELCOME DEFAULT");
        tb2.setText("RESET");

        et.setVisibility(View.INVISIBLE);
        btn.setVisibility(View.INVISIBLE);
        tb2.setVisibility(View.INVISIBLE);
        tb.setText("ENABLE");

        tb.setOnClickListener(new View.OnClickListener() {
            String btnText;
            @Override
            public void onClick(View view) {

                btnText = tb.getText().toString();
                if (btnText.equals("DISABLE")) {
                    et.setVisibility(View.VISIBLE);
                    btn.setVisibility(View.VISIBLE);
                    tb2.setVisibility(View.VISIBLE);
                }
                else if (btnText.equals("ENABLE")) {
                    et.setVisibility(View.INVISIBLE);
                    btn.setVisibility(View.INVISIBLE);
                    tb2.setVisibility(View.INVISIBLE);
                }
            }
        });

        tb2.setOnClickListener(new View.OnClickListener() {
            String btnText;
            @Override
            public void onClick(View view) {

                btnText = tb2.getText().toString();
                if (btnText.equals("RESET")) {
                    et.setText("WELCOME DEFAULT");
                }
                else if (btnText.equals("DEFAULT")) {
                    et.setText(null);
                }
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            String msg_s;
            @Override
            public void onClick(View view) {
                msg_s = et.getText().toString();
                display.putExtra("text", msg_s);
                startActivity(display);
                Toast.makeText(getApplicationContext(), "Message Sent...", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
