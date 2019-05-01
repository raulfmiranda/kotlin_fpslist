package com.blogspot.raulfmiranda.kotlinfpslist

import android.util.Log
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.pressBack
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import java.util.regex.Matcher

@RunWith(AndroidJUnit4::class)
@LargeTest
class MainActivityTest {

    @get:Rule
    var activityRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    @Test
    fun checkItemCountRecyclerView() {
        val itemCount = activityRule.activity.adapter.itemCount
        for(i in 1..5){
            onView(withId(R.id.recViewItems)).perform(RecyclerViewActions.scrollToPosition<ItemAdapter.ViewHolder>(itemCount - 1))
                .check { _, _ ->
                    RecyclerViewMinItemCountAssertion((20 * i) + 10)
                }
        }
    }

    @Test
    fun checkOpenNewActivity() {
        onView(withId(R.id.recViewItems)).perform(RecyclerViewActions.actionOnItemAtPosition<ItemAdapter.ViewHolder>(15, click()))
        onView(withId(R.id.home_btn)).check(matches(isDisplayed()))
    }
}