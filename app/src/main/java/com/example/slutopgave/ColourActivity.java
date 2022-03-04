package com.example.slutopgave;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class ColourActivity extends AppCompatActivity {

    private Spinner spnRed, spnGreen, spnBlue;
    private Button btnColour, btnColourSend;
    private TextView txtTypeColour;

    String red = "00";
    String green = "00";
    String blue = "00";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colour);

        spnRed = findViewById(R.id.spnRed);
        spnGreen = findViewById(R.id.spnGreen);
        spnBlue = findViewById(R.id.spnBlue);
        btnColour = findViewById(R.id.btnColour);
        btnColourSend = findViewById(R.id.btnColourSend);
        txtTypeColour = findViewById(R.id.txtTypeColour);

        String type = getIntent().getStringExtra("Type");
        txtTypeColour.setText(type+"s "+"colour");

        String[] colours = new String[]{"00", "10", "30", "40", "50", "60", "70", "80", "90", "A0", "B0", "C0", "D0", "E0", "F0", "FF"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, colours);

        spnRed.setAdapter(adapter);
        spnGreen.setAdapter(adapter);
        spnBlue.setAdapter(adapter);

        spnRed.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                red = adapterView.getSelectedItem().toString();
                btnColour.setBackgroundColor(Color.parseColor("#"+red+green+blue));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                return;
            }
        });

        spnGreen.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                green = adapterView.getSelectedItem().toString();
                btnColour.setBackgroundColor(Color.parseColor("#"+red+green+blue));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                return;
            }
        });

        spnBlue.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                blue = adapterView.getSelectedItem().toString();
                btnColour.setBackgroundColor(Color.parseColor("#"+red+green+blue));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                return;
            }
        });

        btnColourSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = getIntent();
                intent.putExtra("Colour", "#"+red+green+blue);
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });
    }
}