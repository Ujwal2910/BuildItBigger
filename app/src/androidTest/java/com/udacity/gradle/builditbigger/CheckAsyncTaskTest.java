package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;
/**
 * Created by songoku on 28/12/17.
 */

//code has been seen from-
//http://kevlaichungsing.blogspot.in/2016/03/gradle/testing
@RunWith(AndroidJUnit4.class)
public class CheckAsyncTaskTest {
    @Test
    public void testDoInBackground() throws Exception
    {

        com.udacity.gradle.builditbigger.MainActivityFragment fragment = new
                com.udacity.gradle.builditbigger.MainActivityFragment();

        fragment.testFlag = true;
        new CheckAsyncTask().execute(fragment);
        Thread.sleep(3000);
        assertTrue("Error: Fetched Joke = "
                + fragment.loaded_Joke,
                fragment.loaded_Joke != null);
    }
}

