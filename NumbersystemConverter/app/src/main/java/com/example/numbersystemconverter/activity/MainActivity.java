package com.example.numbersystemconverter.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.numbersystemconverter.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Spinner spinnerFrom;
    private Spinner spinnerTo;
    private ArrayAdapter<CharSequence> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.initSpinner();
        this.setSpinnerToDefaultOptions();
        this.initSpinnerOnClickListener();
    }

    private void initSpinner() {
        this.spinnerFrom = findViewById(R.id.spinner_from);
        this.spinnerTo = findViewById(R.id.spinner_to);

        this.arrayAdapter = ArrayAdapter.createFromResource(
                this, R.array.number_systems_array, android.R.layout.simple_spinner_item);
        this.arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spinnerFrom.setAdapter(this.arrayAdapter);
        this.spinnerTo.setAdapter(this.arrayAdapter);
    }

    private void setSpinnerToDefaultOptions() {
        String spinnerFromDefault = getResources().getString(R.string.number_system_from_default);
        String spinnerToDefault = getResources().getString(R.string.number_system_to_default);
        this.spinnerFrom.setSelection(this.arrayAdapter.getPosition(spinnerFromDefault));
        this.spinnerTo.setSelection(this.arrayAdapter.getPosition(spinnerToDefault));
    }

    private void initSpinnerOnClickListener() {
        this.spinnerFrom.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        this.spinnerTo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}