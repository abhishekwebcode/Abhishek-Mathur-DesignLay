package com.example.admin.designlay;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ChooseClass extends AppCompatActivity {

    Spinner classspinner;
    TextView submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_class);
        getSupportActionBar().setTitle("Class Attendance");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.backarrow);
        classspinner=(Spinner)findViewById(R.id.classspinner);
        submit=(TextView) findViewById(R.id.submitbtn);
        final List<String> list = new ArrayList<String>();
        list.add("Class1-A");
        list.add("Class4A");
        list.add("Class12A");
        list.add("Class12-B");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        classspinner.setAdapter(dataAdapter);
        classspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String classname=list.get(i);
                SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
                SharedPreferences.Editor editor = pref.edit();
                editor.putString("name",classname);
                editor.commit();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }

        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(ChooseClass.this,MainActivity.class);
                startActivity(i);
            }
        });
    }
}
