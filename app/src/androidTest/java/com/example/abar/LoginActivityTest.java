package com.example.abar;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class LoginActivityTest {

    @Rule
    public ActivityScenarioRule<LoginActivity> activityActivityScenarioRule =
            new ActivityScenarioRule<>(LoginActivity.class);

    @Test
    public void testUIElementsAreDisplayed() {
        // Check if email EditText is displayed
        onView(withId(R.id.email))
                .check(matches(isDisplayed()));
    }

    @Test
    public void testUIElementsPasswordAreDisplayed() {
        // Check if password EditText is displayed
        onView(withId(R.id.password))
                .check(matches(isDisplayed()));
    }

    @Test
    public void testUIElementsLoginAreDisplayed() {
        // Check if login Button is displayed
        onView(withId(R.id.login))
                .check(matches(isDisplayed()));
    }

    @Test
    public void testUIElementsRegisterAreDisplayed() {
        // Check if register Button is displayed
        onView(withId(R.id.register_user))
                .check(matches(isDisplayed()));
    }
}
