package com.example.maptest;

import android.view.View;

import androidx.test.espresso.Espresso;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import codingwithmitch.com.googlemapsgoogleplaces.R;

import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)

public class SignInActivityTest {
    @Rule
    public ActivityTestRule<SignInActivity> mActivityTestRule = new ActivityTestRule<SignInActivity>(SignInActivity.class);
    private SignInActivity mSignActivity = null;

    @Before
    public void setUp() throws Exception {
        mSignActivity = mActivityTestRule.getActivity();
    }

    @Test
    public void testLaunch()
    {
        View view =mSignActivity.findViewById(R.id.SignIN_email);
        View view1 =mSignActivity.findViewById(R.id.SignIn_password);

        assertNotNull(view);assertNotNull(view1);

    }

    @After
    public void tearDown() throws Exception {
        mSignActivity =null;
    }
}