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
    // that was calculated. (I have to clear the text before I can enter anything.)
    @Test
    public void can_enter_fahrenheit() {
        onView(withId(R.id.conversion_choice_spinner)).perform(click());
        onView(withText("Fahrenheit to Celsius")).perform(click());
        onView(withId(R.id.first_amount_input)).perform(clearText());
        onView(withId(R.id.first_amount_input)).perform(typeText("45"));
        onView(withId(R.id.second_amount_input)).check(matches(withText("7.22")));
    }

    // This tests if the kilograms value that is displayed on the screen matches the kilograms value
    // that was calculated. (I have to clear the text before I can enter anything.)
    @Test
    public void can_enter_pounds() {
        onView(withId(R.id.conversion_choice_spinner)).perform(click());
        onView(withText("Pounds to Kilograms")).perform(click());
        onView(withId(R.id.first_amount_input)).perform(clearText());
        onView(withId(R.id.first_amount_input)).perform(typeText("60"));
        onView(withId(R.id.second_amount_input)).check(matches(withText("27.22")));
    }

    // This tests if the kilometers value that is displayed on the screen matches the kilometers value
    // that was calculated. (I have to clear the text before I can enter anything.)
    @Test
    public void can_enter_miles() {
        onView(withId(R.id.conversion_choice_spinner)).perform(click());
        onView(withText("Miles to Kilometers")).perform(click());
        onView(withId(R.id.first_amount_input)).perform(clearText());
        onView(withId(R.id.first_amount_input)).perform(typeText("60"));
        onView(withId(R.id.second_amount_input)).check(matches(withText("96.56")));
    }

    // This tests if the centimeters value that is displayed on the screen matches the centimeters value
    // that was calculated. (I have to clear the text before I can enter anything.)
    @Test
    public void can_enter_inches() {
        onView(withId(R.id.conversion_choice_spinner)).perform(click());
        onView(withText("Inches to Centimeters")).perform(click());
        onView(withId(R.id.first_amount_input)).perform(clearText());
        onView(withId(R.id.first_amount_input)).perform(typeText("24"));
        onView(withId(R.id.second_amount_input)).check(matches(withText("60.96")));
    }
}