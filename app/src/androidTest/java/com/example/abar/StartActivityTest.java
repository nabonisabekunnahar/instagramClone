package com.example.abar;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.espresso.intent.Intents;
import androidx.test.espresso.intent.matcher.IntentMatchers;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.intent.Intents.intended;

@RunWith(AndroidJUnit4.class)
public class StartActivityTest {

    @Rule
    public ActivityScenarioRule<StartActivity> activityRule =
            new ActivityScenarioRule<>(StartActivity.class);

    @Before
    public void setUp() {
        Intents.init();
    }

    @After
    public void tearDown() {
        Intents.release();
    }

    @Test
    public void testRegisterButtonNavigatesToRegisterActivity() {
        // Perform click on register button
        onView(withId(R.id.register)).perform(click());

        // Verify that an intent was sent to launch RegisterActivity
        intended(IntentMatchers.hasComponent(RegisterActivity.class.getName()));
    }

    @Test
    public void testLoginButtonNavigatesToLoginActivity() {
        // Perform click on login button
        onView(withId(R.id.login)).perform(click());

        // Verify that an intent was sent to launch LoginActivity
        intended(IntentMatchers.hasComponent(LoginActivity.class.getName()));
    }
}
