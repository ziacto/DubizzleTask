package com.android.dubizzle

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.android.dubizzle.mvi.ui.MainActivity
import com.android.dubizzle.mvi.ui.adapter.DubizzleViewHolder
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule
    @JvmField
    val activityTestRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun shouldBeAbleToLaunchMainScreen() {
        onView(withId(R.id.dubizzle_recycler_view)).check(matches(isDisplayed()))
        onView(withId(R.id.dubizzle_recycler_view)).perform(
            actionOnItemAtPosition<DubizzleViewHolder>(1, click())
        )
    }

    @Test
    fun shouldBeAbleToDisplayDetailScreen() {
        onView(withText(R.string.app_name)).check(matches(isDisplayed()))
        onView(withText(R.string.dubizzle_detail)).check(matches(isDisplayed()))
    }
}
