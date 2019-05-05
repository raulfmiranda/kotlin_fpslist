package com.blogspot.raulfmiranda.kotlinfpslist

import android.view.View
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.contrib.RecyclerViewActions.scrollToPosition
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.matcher.BoundedMatcher
import androidx.annotation.NonNull
import org.hamcrest.Description
import org.hamcrest.Matcher

@RunWith(AndroidJUnit4::class)
@LargeTest
class MainActivityTest {

    @get:Rule
    var activityRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    // Verifica scroll pela quantidade de itens
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

    // Verifica scroll pelo texto que tem no item
    @Test
    fun checkItemText() {
        onView(withId(R.id.recViewItems))
            .perform(
                RecyclerViewActions.scrollToPosition<ItemAdapter.ViewHolder>(20))
            .check(matches(atPosition(20, hasDescendant(withText("Imagem 21")))))
    }

    @Test
    fun checkOpenNewActivity() {
        onView(withId(R.id.recViewItems)).perform(RecyclerViewActions.actionOnItemAtPosition<ItemAdapter.ViewHolder>(15, click()))
        onView(withId(R.id.home_btn)).check(matches(isDisplayed()))
    }

    fun atPosition(position: Int, itemMatcher: Matcher<View>): Matcher<View> {
        checkNotNull(itemMatcher)
        return object : BoundedMatcher<View, RecyclerView>(RecyclerView::class.java) {
            override fun describeTo(description: Description) {
                description.appendText("has item at position $position: ")
                itemMatcher.describeTo(description)
            }

            override fun matchesSafely(view: RecyclerView): Boolean {
                val viewHolder = view.findViewHolderForAdapterPosition(position)
                    ?: // has no item on such position
                    return false
                return itemMatcher.matches(viewHolder.itemView)
            }
        }
    }
}