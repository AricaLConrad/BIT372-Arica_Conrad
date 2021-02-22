package com.example.unitcoverter;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ConverterTest {

    // This unit test checks if the formula for converting Fahrenheit to Celsius is correct.
    @Test
    public void fahrenheit_conversion_isCorrect() {
        assertEquals(0.0, Converter.toCelsius(32),0.01);
    }
    // This unit test checks if the formula for converting pounds to kilograms is correct.
    @Test
    public void pound_conversion_isCorrect() {
        assertEquals(45.36, Converter.toKilograms(100), 0.01);
    }
    // This unit test checks if the formula for converting miles to kilometers is correct.
    @Test
    public void miles_conversion_isCorrect() {
        assertEquals(96.56, Converter.toKilometers(60), 0.01);
    }
    // This unit test checks if the formula for converting inches to centimeters is correct.
    @Test
    public void inches_conversion_isCorrect() {
        assertEquals(152.4, Converter.toCentimeters(60), 0.01);
    }
}