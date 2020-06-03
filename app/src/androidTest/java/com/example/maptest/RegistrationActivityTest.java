package com.example.maptest;

import androidx.test.espresso.Espresso;
import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import codingwithmitch.com.googlemapsgoogleplaces.R;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

import java.util.Random;
import java.util.UUID;

public class RegistrationActivityTest {
    @Rule
    public ActivityTestRule<RegistrationActivity> mRegistrationTEstRule = new ActivityTestRule<RegistrationActivity>(RegistrationActivity.class);

    private String passord = "123456";

    @Before
    public void setUp() throws Exception { }

    @Test
    public void testUserInput() {
        onView(withId(R.id.name_SignUP)).perform(typeText(generateString()));
        onView(withId(R.id.email_SignUP)).perform(typeText(generateString() + "@mail.ru"));
        onView(withId(R.id.password_SignUP)).perform(typeText(passord));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.button_signUP)).perform(click());
        onView(withId(R.id.map)).check(matches(isDisplayed()));
    }

    @After
    public void tearDown() throws Exception {  }

    public static String generateString() {
        String uuid = UUID.randomUUID().toString().replace("-", "");
        return "" + uuid;
    }
}