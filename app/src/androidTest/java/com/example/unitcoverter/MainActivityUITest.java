package com.example.unitcoverter;

import android.content.Context;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.*;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityUITest {
    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);
    // This tests if the app loads with the correct context.
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.unitcoverter", appContext.getPackageName());
    }

    // This tests if the Celsius value that is displayed on the screen matches the Celsius value
    // that was calculated.
    @Test
    public void can_enter_fahrenheit() {
        onView(withId(R.id.fahrenheit_input)).perform(typeText("45"));
        onView(withId(R.id.convert_btn_1)).perform(click());
        onView(withId(R.id.celsius_text)).check(matches(withText("7.22 ºC")));
    }

    // This tests that if no value is inputted for the Fahrenheit to Celsius conversion, the TextView
    // should only display the Celsius units (ºC).
    @Test
    public void should_not_enter_empty_fah() {
        onView(withId(R.id.convert_btn_1)).perform(click());
        onView(withId(R.id.celsius_text)).check(matches(withText("ºC")));
    }

    // This tests if the kilograms value that is displayed on the screen matches the kilograms value
    // that was calculated.
    @Test
    public void can_enter_pounds() {
        onView(withId(R.id.pounds_input)).perform(typeText("100"));
        onView(withId(R.id.convert_btn_2)).perform(click());
        onView(withId(R.id.kilogram_text)).check(matches(withText("45.36 kg")));
    }

    // This tests that if no value is inputted for the pounds to kilograms conversion, the TextView
    // should only display the kilogram units (kg).
    @Test
    public void should_not_enter_empty_pounds() {
        onView(withId(R.id.convert_btn_2)).perform(click());
        onView(withId(R.id.kilogram_text)).check(matches(withText("kg")));
    }
}