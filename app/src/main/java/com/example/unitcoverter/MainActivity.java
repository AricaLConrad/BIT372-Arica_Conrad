package com.example.unitcoverter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
// If I had the ViewModel working, I would need these.
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.unitcoverter.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    // References to variables.
    public int formulaID;
    public TextView secondInput;
    private Unit unit;
    // public UnitViewModel unitViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create a new unit.
        unit = new Unit("34.89");

        // This is how the MutableLiveData is bound to the activity's layout.
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setLifecycleOwner(this);
        binding.setUnit(unit);

        // Reference the TextView that will show the calculated result.
        secondInput = findViewById(R.id.second_amount_input);

        // Access the spinner.
        // This tutorial was helpful in creating the spinner: https://www.tutorialspoint.com/android/android_spinner_control.htm
        Spinner conversionChoice = findViewById(R.id.conversion_choice_spinner);
        // Set a listener to the spinner.
        conversionChoice.setOnItemSelectedListener(this);
        // Create an adapter for the spinner.
        ArrayAdapter<CharSequence> adapter =
                ArrayAdapter.createFromResource(this, R.array.conversion_formulas, android.R.layout.simple_spinner_item);
        // Choose the drop-down layout style for the spinner.
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Attach the adapter to the spinner.
        conversionChoice.setAdapter(adapter);

        // -----------------------------------

        // IMPORTANT NOTE:
        // I had this code here to try an implement the ViewModel, but the TextView would not display
        // any text, even when I adjusted the XML code. I am not sure what is going wrong here.
        /*
        unitViewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(UnitViewModel.class);
        final Observer<String> unitObserver = new Observer<String>() {
            @Override
            public void onChanged(String s) {
                if (!(s.length() == 0)) {
                    String result = unitViewModel.returnCalculation(s);
                    secondInput.setText(result);
                }
            }
        };
        unitViewModel.getUnit().observe(this, unitObserver);
        */

        // -----------------------------------
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        // Store the item that was selected on the spinner.
        String item = adapterView.getItemAtPosition(i).toString();

        // Provide a message to the user confirming what they chose.
        Toast.makeText(adapterView.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();

        // Access the two TextViews that display the units.
        TextView firstUnits = findViewById(R.id.first_units_text);
        TextView secondUnits = findViewById(R.id.second_units_text);

        // The switch case will display the proper units for its respective formula.
        switch (item) {
            case "Fahrenheit to Celsius":
                firstUnits.setText(String.format("ºF"));
                secondUnits.setText(String.format("ºC"));
                formulaID = 0;
                break;
            case "Pounds to Kilograms":
                firstUnits.setText(String.format("lbs"));
                secondUnits.setText(String.format("kg"));
                formulaID = 1;
                break;
            case "Miles to Kilometers":
                firstUnits.setText(String.format("mi"));
                secondUnits.setText(String.format("km"));
                formulaID = 2;
                break;
            case "Inches to Centimeters":
                firstUnits.setText(String.format("in"));
                secondUnits.setText(String.format("cm"));
                formulaID = 3;
                break;
        }

        // Pass the formula ID so the Unit class can access it.
        unit.setFormulaId(formulaID);

        // -----------------------------------
        // IMPORTANT NOTE:
        // If I were to use the ViewModel, I would need this line of code.
        //unitViewModel.setFormulaId(formulaID);
        // -----------------------------------
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        // Auto-generated method, so I did not add anything here.
    }
}