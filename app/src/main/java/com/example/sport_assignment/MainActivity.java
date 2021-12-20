package com.example.sport_assignment;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.filament.View;
import com.google.gson.Gson;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText height;
    private EditText weight;
    private TextView resultText;
    private Button btnresult;
    private Button btnsave;
    private Spinner spinner;
    private EditText edtName;
    private EditText edtEmail;
    private EditText edtPhone;
    String calculation, result;
    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;
    public static final String Name = "Name";
    public static final String Email= "Email";
    public static final String Phone = "Phone";
    public static final String Gender = "Gender";
    public static final String Weight = "Weight";
    public static final String Height = "Height";
    String nameStr,emailStr,phoneStr,genderStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupViews();
        setUpSharedPrefs();
        loadPrefs();
    }

    private void PopulateSpinner() {
        ArrayList<String> data = new ArrayList<>();
        data.add("Female");
        data.add("Male");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, data);
        spinner.setAdapter(adapter);
    }

    private  void setupViews(){
        edtName = findViewById(R.id.edtname);
        edtEmail = findViewById(R.id.edtemail);
        edtPhone = findViewById(R.id.edtphone);
        spinner = (Spinner) findViewById(R.id.spinner);
        weight = findViewById(R.id.weight);
        height = findViewById(R.id.height);
        PopulateSpinner();
        btnsave = findViewById(R.id.btnsave);
        btnresult = findViewById(R.id.btnresult);
    }
    private void setUpSharedPrefs(){
        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        editor = prefs.edit();

    }
    private void loadPrefs() {
        nameStr = prefs.getString(Name, "");
        emailStr = prefs.getString(Email, "");
        phoneStr = prefs.getString(Phone, "");
        genderStr = prefs.getString(Gender, "");
        edtName.setText(nameStr);
        edtEmail.setText(emailStr);
        edtPhone.setText(phoneStr);
        spinner.setSelected(Boolean.parseBoolean(genderStr));

    }
    public void btnResultOnClick(android.view.View view) {

    //    String msg = resultText.getText().toString();
        Intent intent = new Intent(this, MainActivity2.class);
  //      intent.putExtra("data", msg);
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

    public void btnSaveOnClick(android.view.View view) {

        Info[] infos = new Info[1];
        infos[0] = new Info("Yusra", "yusra@gmail.com","05395641","Female");

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = prefs.edit();
        Gson gson = new Gson();
        String infoString = gson.toJson(infos);

        editor.putString("Name", infoString);
        editor.commit();
        Toast.makeText(this, "Data Saved:\n" + infoString,
                Toast.LENGTH_SHORT).show();

    }
}