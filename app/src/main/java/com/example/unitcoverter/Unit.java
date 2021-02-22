package com.example.unitcoverter;

import androidx.lifecycle.MutableLiveData;

public class Unit {

    public MutableLiveData<String> firstUnit;
    private int formulaID;

    public Unit(String firstUnit) {
        this.firstUnit = new MutableLiveData<>();
        this.firstUnit.setValue(firstUnit);
    }

    public String getUnit() {
        return firstUnit.getValue().toString();
    }

    public void setFormulaId(int id) {
        formulaID = id;
    }

    public String returnCalculation(String firstInput) {

        // Convert the string variable to a double.
        double firstValue;

        // Check if the input is good.
        if (firstInput.length() == 0) {
            return "";
        }
        else {
            firstValue = Double.parseDouble(firstInput);
        }

        // Create a new result variable.
        double calculatedResult = 0.0;

        // Now the switch statement, where the specific formula is called.
        switch (formulaID) {
            case 0:
                calculatedResult = Converter.toCelsius(firstValue);
                break;
            case 1:
                calculatedResult = Converter.toKilograms(firstValue);
                break;
            case 2:
                calculatedResult = Converter.toKilometers(firstValue);
                break;
            case 3:
                calculatedResult = Converter.toCentimeters(firstValue);
                break;
        }

        // Return the result as a formatted string.
        return String.format("%.2f", calculatedResult);
    }
}
