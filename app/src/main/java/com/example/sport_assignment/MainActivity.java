package com.example.sport_assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.filament.View;

public class MainActivity extends AppCompatActivity {


    private final String gender[] = {"Choose", "Female", "Male"};
    private EditText height;
    private EditText weight;
    private TextView resultText;
    String calculation, result;
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = findViewById(R.id.dynamic_spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<>
                (MainActivity.this, android.R.layout.simple_spinner_dropdown_item, gender);
        spinner.setAdapter(adapter);
        setContentView(R.layout.activity_main);
        weight = findViewById(R.id.weight);
        height = findViewById(R.id.height);
        resultText = findViewById(R.id.result);

        button =(Button) findViewById(R.id.button);
        button.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                OnClick();
            }
        });
    }


    public void OnClick() {
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }

    public void calculateBMI(View view) {
        String w = weight.getText().toString();
        String h = height.getText().toString();

        float weightvalue = Float.parseFloat(w);
        float heightvalue = Float.parseFloat(h) / 100;
        float bmi = weightvalue / (heightvalue * heightvalue);

        if (bmi < 18.5) {
            result = "Under Weight";
        } else if (bmi >= 18.5 && bmi <= 24.9) {
            result = "Healthy ";
        } else if (bmi >= 25.0 && bmi <= 29.9) {
            result = "Over Weight";
        } else {
            result = "Obese";
        }
        calculation = "Result \n"+ bmi+ "\n" + result;
        resultText.setText(calculation);
    }
}