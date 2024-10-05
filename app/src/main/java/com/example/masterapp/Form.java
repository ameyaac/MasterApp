package com.example.masterapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class Form extends AppCompatActivity {

    TextView name, result;
    EditText nameInput;
    RadioGroup artists;
    RadioButton taylor, selena;
    CheckBox album1, album2, album3;
    ImageView albumPic;
    Button okBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setTitle(R.string.form);

        result = findViewById(R.id.textView2);
        nameInput = findViewById(R.id.editTextText);
        artists = findViewById(R.id.radio);
        taylor = findViewById(R.id.radioButton);
        selena = findViewById(R.id.radioButton2);
        album1 = findViewById(R.id.checkBox3);
        album2 = findViewById(R.id.checkBox4);
        album3 = findViewById(R.id.checkBox5);
        albumPic = findViewById(R.id.imageView);
        okBtn = findViewById(R.id.button);

        artists.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup rg, int checkedId) {
                if(checkedId == R.id.radioButton) {
                    album1.setText("High Infidelity");
                    album2.setText("Enchanted");
                    album3.setText("August");
                } else if (checkedId == R.id.radioButton2) {
                    album1.setText("Rare");
                    album2.setText("Who says");
                    album3.setText("999");
                }

                album1.setChecked(false);
                album2.setChecked(false);
                album3.setChecked(false);
            }
        });

        okBtn.setOnClickListener(v -> {
            String userName = nameInput.getText().toString();

            if (userName.isEmpty()
                    || (!taylor.isChecked() && !selena.isChecked())
                    || (!album1.isChecked() && !album2.isChecked() && !album3.isChecked())) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            String selectedArtist=" ";
            int selectedImg = 0;

            if(taylor.isChecked()){
                selectedArtist = taylor.getText().toString();
                selectedImg=R.drawable.taylor;
            } else if (selena.isChecked()) {
                selectedArtist = selena.getText().toString();
                selectedImg = R.drawable.selena;
            }

            StringBuilder selectedAlbums = new StringBuilder();
            if (album1.isChecked()) {
                selectedAlbums.append(album1.getText().toString()).append(", ");
            }
            if (album2.isChecked()) {
                selectedAlbums.append(album2.getText().toString()).append(", ");
            }
            if (album3.isChecked()) {
                selectedAlbums.append(album3.getText().toString()).append(", ");
            }

            if (selectedAlbums.length() > 0) {
                selectedAlbums.setLength(selectedAlbums.length() - 2);
            }

            String resultMessage = userName + "'s favorite artist is " + selectedArtist + " and their songs " + selectedAlbums.toString() + ".";
            result.setText(resultMessage);

            if(selectedImg != 0)
            {
                albumPic.setImageResource(selectedImg);
            }

            Toast.makeText(Form.this, "Hello, " + userName + ". You like " + selectedArtist + ".", Toast.LENGTH_LONG ).show();
        });
    }
}