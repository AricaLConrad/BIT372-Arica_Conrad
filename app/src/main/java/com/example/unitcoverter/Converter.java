package com.example.unitcoverter;

public class Converter {
    // This method takes a passed-in temperature for Fahrenheit, calculates the temperature in
    // Celsius, and returns the value.
    public static float toCelsius(float fah) {
        return (fah - 32) * 5/9;
    }

    // This method takes a passed-in weight in pounds, calculates the weight in kilograms, and
    // returns the value.
    public static double toKilograms(float pounds) {
        return (pounds * 0.45359237);
    }
}
