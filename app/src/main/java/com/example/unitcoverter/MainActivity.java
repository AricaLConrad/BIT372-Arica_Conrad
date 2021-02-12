package com.example.unitcoverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // References the first convert button, which is for the Fahrenheit to Celsius conversion.
        Button fbtn = findViewById(R.id.convert_btn_1);

        // References the Fahrenheit temperature text input and the TextView that will display the
        // Celsius temperature value.
        EditText finput = findViewById(R.id.fahrenheit_input);
        TextView ctxt = findViewById(R.id.celsius_text);
        // When the convert button is pressed, it first checks to see if numbers were actually inputted.
        // If not, no new text wll be displayed. Otherwise, the Celsius temperature is calculated,
        // stored, and then displayed in the TextView.
        fbtn.setOnClickListener(v -> {
            if (finput.getText().length() == 0)
                return;
            double celsius = Converter.toCelsius(Float.parseFloat(finput.getText().toString()));
            ctxt.setText(String.format("%.2f ºC", celsius));
        });

        // References the second convert button, which is for the pounds to kilograms conversion.
        Button poundButton = findViewById(R.id.convert_btn_2);

        // References the pounds text input and the TextView that will display the kilogram values.
        EditText poundInput = findViewById(R.id.pounds_input);
        TextView kilogramText = findViewById(R.id.kilogram_text);
        // When the convert button is pressed, it first checks to see if numbers were actually inputted.
        // If not, no new text will be displayed. Otherwise, the kilograms value is calculated,
        // stored, and then displayed in the TextView.
        poundButton.setOnClickListener(v -> {
            if (poundInput.getText().length() == 0) {
                return;
            }
            double kilograms = Converter.toKilograms(Float.parseFloat(poundInput.getText().toString()));
            kilogramText.setText(String.format("%.2f kg", kilograms));
        });
    }
}