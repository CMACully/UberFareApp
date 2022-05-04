package com.example.uberfareapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    // Set the cars array as well as the global variables
    String[] cars = {"Smart car", "Traditional Sedan", "Minivan"};
    private double milesEntered;
    private double totalDue;
    private double milageRate = 3.25;
    private double minivanFee = 8.00;
    private double smartCarFee = 5.00;
    private double traditionalSedan = 3.00;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = (Spinner)findViewById(R.id.spnrCars);
        ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this, R.layout.spinner, cars);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(MainActivity.this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String selectedCar = adapterView.getItemAtPosition(i).toString();

        // Using a switch/case to figure the position(SelectedItem)
        // and sets the portion of totalDue
        switch (i) {
            case 0:
                totalDue = smartCarFee;
                break;
            case 1:
                totalDue = traditionalSedan;
                break;
            case 2:
                totalDue = minivanFee;
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    // Create a getMileage method that will be set as the on-Click event for
    // the Submit button.
    public void getMileage(View view){
        // Holding the users input(string) with TextView and converting
        // it to an int with Integer.parseInt
        TextView totalMileage = findViewById(R.id.enterMiles);
        String inputMiles = totalMileage.getText().toString();
        milesEntered = (Integer.parseInt(inputMiles) * milageRate);
        // Use the TextView to get the txtTotal textbox
        // and display the Total by adding the totalDue and milesEntered
        TextView textView = (TextView)findViewById(R.id.txtTotal);
        double total = totalDue + milesEntered;
        textView.setText("Total Due: $" + total);
    }
}