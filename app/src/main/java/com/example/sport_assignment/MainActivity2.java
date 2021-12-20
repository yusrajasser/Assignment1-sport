package com.example.sport_assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    String bmiList[] = {"Below 18.5 (Under Weight)","18.5 - 24.9 (Healthy)","25.0 - 29.9  (Over Weight)","Above 30.0  (Obese)"};
   // int bmiImages[]={R.drawable.underweight,R.drawable.normal,R.drawable.overweight,R.drawable.obese};
    ListView listView;
    private TextView txtShowResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        txtShowResult = findViewById(R.id.txtShowResult);
        String msg = intent.getStringExtra("data");
        txtShowResult.setText(msg);

        listView = findViewById(R.id.list_view);
        ArrayAdapter<String> array;
        array = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, bmiList);
        listView.setAdapter(array);


    }
}