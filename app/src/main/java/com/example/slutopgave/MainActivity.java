package com.example.slutopgave;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView txtNames;
    private Button btnName, btnColour;
    private String type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNames = findViewById(R.id.txtNames);
        btnName = findViewById(R.id.btnName);
        btnColour = findViewById(R.id.btnColour);

        ActivityResultLauncher<Intent> nameLauncher;
        nameLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == Activity.RESULT_OK) {
                            type = result.getData().getStringExtra("Type");
                            String name = result.getData().getStringExtra("Name");
                            txtNames.setText(type + ": " + name);
                        } else {
                            txtNames.setText("Here comes the name");
                        }
                    }
                });

        btnName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentName = new Intent(MainActivity.this, NameActivity.class);
                nameLauncher.launch(intentName);
            }
        });

        ActivityResultLauncher<Intent> colourLauncher;
        colourLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == Activity.RESULT_OK) {
                            String colour = result.getData().getStringExtra("Colour");
                            txtNames.setBackgroundColor(Color.parseColor(colour));
                        }
                    }
                });

        btnColour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentColour = new Intent(MainActivity.this, ColourActivity.class);
                intentColour.putExtra("Type", type);
                colourLauncher.launch(intentColour);
            }
        });
    }
}