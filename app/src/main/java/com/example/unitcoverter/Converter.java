package com.example.unitcoverter;

public class Converter {
    // This method takes a passed-in temperature for Fahrenheit, calculates the temperature in
    // Celsius, and returns the value.
    public static double toCelsius(double fah) {
        return (fah - 32) * 5/9;
    }

    // This method takes a passed-in weight in pounds, calculates the weight in kilograms, and
    // returns the value.
    public static double toKilograms(double pounds) {
        return (pounds * 0.45359237);
    }

    // This method takes a passed-in distance in miles, calculates the distance in kilometers, and
    // returns the value.
    public static double toKilometers(double miles) {
        return (miles * 1.609344);
    }

    // This method takes a passed-in length in inches, calculates the length in centimeters, and
    // returns the value.
    public static double toCentimeters(double inches) {
        return (inches * 2.54);
    }
}
