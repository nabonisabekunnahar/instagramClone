package com.example.abar;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class LoginActivityTest {

    @Rule
    public ActivityScenarioRule<LoginActivity>activityActivityScenarioRule=
            new ActivityScenarioRule<>(LoginActivity.class);// 60 seconds timeout


    @Test
    public void testUIElementsAreDisplayed() {
        // Check if email EditText is displayed
        onView(withId(R.id.email))
                .check(matches(isDisplayed()));

    }
    @Test
    public void testUIElementsPasswordAreDisplayed() {
        // Check if email EditText is displayed
        onView(withId(R.id.password))
                .check(matches(isDisplayed()));

    }
    @Test
    public void testUIElementsLoginAreDisplayed() {
        // Check if email EditText is displayed
        onView(withId(R.id.login))
                .check(matches(isDisplayed()));

    }
    @Test
    public void testUIElementsRegisterAreDisplayed() {
        // Check if email EditText is displayed
        onView(withId(R.id.register_user))
                .check(matches(isDisplayed()));

    }

}