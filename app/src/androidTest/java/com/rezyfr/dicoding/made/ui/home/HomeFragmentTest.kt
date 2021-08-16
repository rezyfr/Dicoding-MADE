package com.rezyfr.dicoding.made.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.rezyfr.dicoding.made.R
import com.rezyfr.dicoding.made.ui.MainActivity
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class HomeFragmentTest {
    @Before
    fun setUp() {
        ActivityScenario.launch(MainActivity::class.java)
    }

    @Test
    fun assertDisplayed(): Unit = runBlocking {
        onView(withId(R.id.img_splashscreen)).check(matches(isDisplayed()))
        delay(4000)
        onView(withId(R.id.tv_nowplaying)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_nowplaying)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_now_playing)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_now_playing)).check(matches(isDisplayed()))

        onView(withId(R.id.rv_nowplaying)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0,
                ViewActions.click()
            ))
        onView(withId(R.id.iv_poster)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_vote_count)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_duration)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_date)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_overview)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_back)).perform(ViewActions.click())
    }
}