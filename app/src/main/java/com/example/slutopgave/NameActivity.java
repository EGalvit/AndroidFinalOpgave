package com.example.slutopgave;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class NameActivity extends AppCompatActivity {

    private RadioGroup rgChoice;
    private RadioButton rbMother, rbFather, rbCat, rbDog;
    private Button btnNameSend;
    private EditText etxtName;

    private String choice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);

        rgChoice = findViewById(R.id.rgChoice);
        rbMother = findViewById(R.id.rbMother);
        rbFather = findViewById(R.id.rbFather);
        rbCat = findViewById(R.id.rbCat);
        rbDog = findViewById(R.id.rbDog);
        btnNameSend = findViewById(R.id.btnNameSend);
        etxtName = findViewById(R.id.etxtName);


        rgChoice.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch(i) {
                    case R.id.rbMother:
                        choice = "Mother";
                        break;
                    case R.id.rbFather:
                        choice = "Father";
                        break;
                    case R.id.rbCat:
                        choice = "Cat";
                        break;
                    case R.id.rbDog:
                        choice = "Dog";
                        break;
                }
            }
        });

        btnNameSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = etxtName.getText().toString();
                Intent intent = getIntent();
                intent.putExtra("Name", name);
                intent.putExtra("Type", choice);
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });
    }
}