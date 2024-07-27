package com.aliozdemir.helloandroid

import android.content.Intent
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.Lifecycle
import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import junit.framework.TestCase.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Test
    fun textActivity1() {
        launchActivity<MainActivity>().use { scenario ->
            scenario.moveToState(Lifecycle.State.RESUMED)   // Lifecycle state'ini değiştiriyoruz.
        }
    }

    @Test
    fun textActivity2() {
        launchActivity<MainActivity>().use { scenario ->
            scenario.recreate()     // onCreate()'ten itibaren yeniden başlatıyoruz.
        }
    }

    @Test
    fun textActivity3() {
        launchActivity<MainActivity>().use { scenario ->
            scenario.onActivity { activity ->       // Başka bir activity'yi açabiliyoruz.
                val intent = Intent(activity, SettingsActivity::class.java)
                startActivity(activity, intent, null)
            }
        }
    }

    @Test
    fun textActivity4() {
        launchActivity<MainActivity>().use { scenario ->
            onView(withId(R.id.btnOpenSettingsActivity)).perform(click())
        }
    }

    // Bunlar Unit Test olmalıydı. UI ile alakası yok.
    @Test
    fun textActivity5() {
        launchActivity<MainActivity>().use { scenario ->
            val name = "John"
            val surname = "Doe"
            scenario.onActivity { activity ->
                val result = activity.someBusinessLogic(name, surname)
                assertEquals("Hello John Doe", result)
            }
        }
    }

    // Bunlar Unit Test olmalıydı. UI ile alakası yok.
    @Test
    fun textActivity6() {
        launchActivity<MainActivity>().use { scenario ->
            val name = "John"
            scenario.onActivity { activity ->
                val result = activity.someBusinessLogic(name, null)
                assertEquals("Hello John null", result)
            }
        }
    }

    // Bunlar Unit Test olmalıydı. UI ile alakası yok.
    @Test
    fun textActivity7() {
        launchActivity<MainActivity>().use { scenario ->
            val surname = "Doe"
            scenario.onActivity { activity ->
                val result = activity.someBusinessLogic(null, surname)
                assertEquals("Hello null Doe", result)
            }
        }
    }

    // Bunlar Unit Test olmalıydı. UI ile alakası yok.
    @Test
    fun textActivity8() {
        launchActivity<MainActivity>().use { scenario ->
            scenario.onActivity { activity ->
                val result = activity.someBusinessLogic(null, null)
                assertEquals("Hello null null", result)
            }
        }
    }

}