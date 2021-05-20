package com.example.task61d;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

public class final1 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    ImageView I1, I2, I3, I4;
    Button add_new;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);
        I1 = findViewById(R.id.I1);
        I2 = findViewById(R.id.I2);
        I3 = findViewById(R.id.I3);
        I4 = findViewById(R.id.I4);
        //cam = findViewById(R.id.cam);


        //cam.setImageResource(R.drawable.camera);
        I1.setImageResource(R.drawable.bugger);
        I2.setImageResource(R.drawable.burger_2);
        I3.setImageResource(R.drawable.soup);
        I4.setImageResource(R.drawable.pizza);
        add_new = findViewById(R.id.add_new);

        Spinner spin = (Spinner) findViewById(R.id.spinner);
        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.spinner, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        add_new.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(final1.this, addnew_page.class);
                startActivity(intent);


            }
        });


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}