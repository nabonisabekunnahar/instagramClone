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
public class OptionsActivityTest {

    @Rule
    public ActivityScenarioRule<OptionsActivity> activityRule =
            new ActivityScenarioRule<>(OptionsActivity.class);

    @Before
    public void setUp() {
        Intents.init();
    }

    @After
    public void tearDown() {
        Intents.release();
    }

    @Test
    public void testUIElementsAreDisplayed() {
        // Check if settings TextView is displayed
        onView(withId(R.id.settings)).check(matches(isDisplayed()));

        // Check if logOut TextView is displayed
        onView(withId(R.id.logout)).check(matches(isDisplayed()));
    }

    @Test
    public void testLogOutButtonNavigatesToStartActivity() {
        // Perform click on logOut button
        onView(withId(R.id.logout)).perform(click());

        // Verify that an intent was sent to launch StartActivity
        intended(IntentMatchers.hasComponent(StartActivity.class.getName()));
    }



}
