package com.example.finalassig

import android.app.Activity
import android.view.View
import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import org.hamcrest.Matcher
import org.junit.Before
import org.junit.Test
import kotlin.system.measureTimeMillis

class Page2Test {

    private lateinit var scenario: ActivityScenario<Activity>

    @Before
    fun setup() {
        scenario = ActivityScenario.launch(Activity::class.java)
        scenario.moveToState(Lifecycle.State.RESUMED)
    }

    @Test
    fun testButtonClick2() {
        Thread.sleep(measureTimeMillis { 3000 })
        onView(withId(R.id.login)).perform(click())
    }

    private fun withId(id: Int): Matcher<View> {
        return withId(id)
    }
}
