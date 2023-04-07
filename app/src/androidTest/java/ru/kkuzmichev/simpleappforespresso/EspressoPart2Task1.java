package ru.kkuzmichev.simpleappforespresso;


import androidx.test.espresso.DataInteraction;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.intent.Intents;
import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.filters.LargeTest;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import static androidx.test.InstrumentationRegistry.getInstrumentation;
import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.assertion.ViewAssertions.*;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasAction;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasData;
import static androidx.test.espresso.matcher.ViewMatchers.*;

import ru.kkuzmichev.simpleappforespresso.R;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class EspressoPart2Task1 {

    //    @Rule
//    public ActivityScenarioRule<MainActivity> mActivityScenarioRule =
//            new ActivityScenarioRule<>(MainActivity.class); //для варианта 2
    @Rule
    public IntentsTestRule intentsTestRule = new IntentsTestRule(MainActivity.class); //вариант 1 для вызова перед всеми тестами

    @Test
    public void espressoPart2Task1() {
        ViewInteraction overflowMenuButton = onView(
                allOf(withParent(withParent(withId(R.id.toolbar)))));
        overflowMenuButton.check(matches(isDisplayed()));
        overflowMenuButton.perform(click());

        ViewInteraction materialTextView = onView(
                allOf(withId(androidx.recyclerview.R.id.title),
                        withParent(withParent(
                                withId(androidx.constraintlayout.widget.R.id.content)))));
        materialTextView.check(matches(isDisplayed()));
//        Intents.init(); //вариант 2 для вызова в конкретном тесте
        materialTextView.perform(click());
        intended(hasData("https://google.com"));
        intended(hasAction(Intent.ACTION_VIEW));
//        Intents.release(); //вариант 2 для вызова в конкретном тесте
    }
}
