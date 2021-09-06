package com.example.grocerieslistapp;


import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.DataInteraction;
import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.pressImeActionButton;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>( MainActivity.class );

    @Test
    public void mainActivityTest() {
        ViewInteraction appCompatEditText = onView(
                allOf( withId( R.id.editItem ),
                        childAtPosition(
                                childAtPosition(
                                        withId( R.id.itemName ),
                                        0 ),
                                0 ),
                        isDisplayed() ) );
        appCompatEditText.perform( replaceText( "JAMBO" ), closeSoftKeyboard() );

        DataInteraction appCompatCheckedTextView = onData( anything() )
                .inAdapterView( childAtPosition(
                        withClassName( is( "android.widget.PopupWindow$PopupBackgroundView" ) ),
                        0 ) )
                .atPosition( 0 );
        appCompatCheckedTextView.perform( click() );

        ViewInteraction appCompatEditText2 = onView(
                allOf( withId( R.id.editPrice ),
                        childAtPosition(
                                childAtPosition(
                                        withId( R.id.price ),
                                        0 ),
                                0 ),
                        isDisplayed() ) );
        appCompatEditText2.perform( replaceText( "7" ), closeSoftKeyboard() );

        ViewInteraction appCompatEditText3 = onView(
                allOf( withId( R.id.editQuantity ),
                        childAtPosition(
                                childAtPosition(
                                        withId( R.id.edtQuantity ),
                                        0 ),
                                0 ),
                        isDisplayed() ) );
        appCompatEditText3.perform( replaceText( "6" ), closeSoftKeyboard() );

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep( 250 );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction appCompatSpinner = onView(
                allOf( withId( R.id.unit_spinner ),
                        childAtPosition(
                                allOf( withId( R.id.addform ),
                                        childAtPosition(
                                                withId( R.id.design_bottom_sheet ),
                                                0 ) ),
                                6 ),
                        isDisplayed() ) );
        appCompatSpinner.perform( click() );

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep( 250 );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        DataInteraction appCompatCheckedTextView2 = onData( anything() )
                .inAdapterView( childAtPosition(
                        withClassName( is( "android.widget.PopupWindow$PopupBackgroundView" ) ),
                        0 ) )
                .atPosition( 3 );
        appCompatCheckedTextView2.perform( click() );

        ViewInteraction appCompatEditText4 = onView(
                allOf( withId( R.id.editQuantity ), withText( "6" ),
                        childAtPosition(
                                childAtPosition(
                                        withId( R.id.edtQuantity ),
                                        0 ),
                                0 ),
                        isDisplayed() ) );
        appCompatEditText4.perform( pressImeActionButton() );

        ViewInteraction appCompatButton = onView(
                allOf( withId( R.id.savebtn ), withText( "save" ),
                        childAtPosition(
                                allOf( withId( R.id.addform ),
                                        childAtPosition(
                                                withId( R.id.design_bottom_sheet ),
                                                0 ) ),
                                3 ),
                        isDisplayed() ) );
        appCompatButton.perform( click() );

        ViewInteraction view = onView(
                allOf( withId( R.id.touch_outside ),
                        childAtPosition(
                                allOf( withId( R.id.coordinator ),
                                        childAtPosition(
                                                withId( R.id.container ),
                                                0 ) ),
                                0 ),
                        isDisplayed() ) );
        view.perform( click() );

        ViewInteraction appCompatImageButton = onView(
                allOf( withId( R.id.edit_grocery ), withContentDescription( "edit" ),
                        childAtPosition(
                                allOf( withId( R.id.groceries_row_layout ),
                                        childAtPosition(
                                                withId( R.id.groceries_row ),
                                                0 ) ),
                                7 ),
                        isDisplayed() ) );
        appCompatImageButton.perform( click() );

        ViewInteraction appCompatEditText5 = onView(
                allOf( withId( R.id.editItem ), withText( "JAMBO" ),
                        childAtPosition(
                                childAtPosition(
                                        withId( R.id.itemName ),
                                        0 ),
                                1 ),
                        isDisplayed() ) );
        appCompatEditText5.perform( click() );

        ViewInteraction appCompatEditText6 = onView(
                allOf( withId( R.id.editItem ), withText( "JAMBO" ),
                        childAtPosition(
                                childAtPosition(
                                        withId( R.id.itemName ),
                                        0 ),
                                1 ),
                        isDisplayed() ) );
        appCompatEditText6.perform( replaceText( "JAMBOREE" ) );

        ViewInteraction appCompatEditText7 = onView(
                allOf( withId( R.id.editItem ), withText( "JAMBOREE" ),
                        childAtPosition(
                                childAtPosition(
                                        withId( R.id.itemName ),
                                        0 ),
                                1 ),
                        isDisplayed() ) );
        appCompatEditText7.perform( closeSoftKeyboard() );

        ViewInteraction appCompatEditText8 = onView(
                allOf( withId( R.id.editItem ), withText( "JAMBOREE" ),
                        childAtPosition(
                                childAtPosition(
                                        withId( R.id.itemName ),
                                        0 ),
                                1 ),
                        isDisplayed() ) );
        appCompatEditText8.perform( pressImeActionButton() );

        ViewInteraction appCompatEditText9 = onView(
                allOf( withId( R.id.editPrice ),
                        childAtPosition(
                                childAtPosition(
                                        withId( R.id.price ),
                                        0 ),
                                1 ),
                        isDisplayed() ) );
        appCompatEditText9.perform( replaceText( "67" ), closeSoftKeyboard() );

        ViewInteraction appCompatEditText10 = onView(
                allOf( withId( R.id.editQuantity ),
                        childAtPosition(
                                childAtPosition(
                                        withId( R.id.edtQuantity ),
                                        0 ),
                                1 ),
                        isDisplayed() ) );
        appCompatEditText10.perform( replaceText( "5" ), closeSoftKeyboard() );

        ViewInteraction appCompatButton2 = onView(
                allOf( withId( R.id.savebtn ), withText( "save" ),
                        childAtPosition(
                                allOf( withId( R.id.addform ),
                                        childAtPosition(
                                                withId( R.id.design_bottom_sheet ),
                                                0 ) ),
                                3 ),
                        isDisplayed() ) );
        appCompatButton2.perform( click() );

        ViewInteraction appCompatCheckBox = onView(
                allOf( withId( R.id.checkBox ),
                        childAtPosition(
                                allOf( withId( R.id.groceries_row_layout ),
                                        childAtPosition(
                                                withId( R.id.groceries_row ),
                                                0 ) ),
                                8 ),
                        isDisplayed() ) );
        appCompatCheckBox.perform( click() );

        ViewInteraction appCompatCheckBox2 = onView(
                allOf( withId( R.id.checkBox ),
                        childAtPosition(
                                allOf( withId( R.id.groceries_row_layout ),
                                        childAtPosition(
                                                withId( R.id.groceries_row ),
                                                0 ) ),
                                8 ),
                        isDisplayed() ) );
        appCompatCheckBox2.perform( click() );

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep( 250 );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction overflowMenuButton = onView(
                allOf( withContentDescription( "More options" ),
                        childAtPosition(
                                childAtPosition(
                                        withId( R.id.action_bar ),
                                        1 ),
                                0 ),
                        isDisplayed() ) );
        overflowMenuButton.perform( click() );

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep( 250 );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction appCompatTextView = onView(
                allOf( withId( R.id.title ), withText( "delete all groceries" ),
                        childAtPosition(
                                childAtPosition(
                                        withId( R.id.content ),
                                        0 ),
                                0 ),
                        isDisplayed() ) );
        appCompatTextView.perform( click() );

        ViewInteraction floatingActionButton = onView(
                allOf( withId( R.id.floataddbtn ), withContentDescription( "addgroceries" ),
                        childAtPosition(
                                allOf( withId( R.id.main_layout ),
                                        childAtPosition(
                                                withId( android.R.id.content ),
                                                0 ) ),
                                1 ),
                        isDisplayed() ) );
        floatingActionButton.perform( click() );

        ViewInteraction appCompatEditText11 = onView(
                allOf( withId( R.id.editItem ), withText( "JAMBOREE" ),
                        childAtPosition(
                                childAtPosition(
                                        withId( R.id.itemName ),
                                        0 ),
                                1 ),
                        isDisplayed() ) );
        appCompatEditText11.perform( click() );

        ViewInteraction appCompatEditText12 = onView(
                allOf( withId( R.id.editItem ), withText( "JAMBOREE" ),
                        childAtPosition(
                                childAtPosition(
                                        withId( R.id.itemName ),
                                        0 ),
                                1 ),
                        isDisplayed() ) );
        appCompatEditText12.perform( replaceText( "7877878" ) );

        ViewInteraction appCompatEditText13 = onView(
                allOf( withId( R.id.editItem ), withText( "7877878" ),
                        childAtPosition(
                                childAtPosition(
                                        withId( R.id.itemName ),
                                        0 ),
                                1 ),
                        isDisplayed() ) );
        appCompatEditText13.perform( closeSoftKeyboard() );

        ViewInteraction appCompatEditText14 = onView(
                allOf( withId( R.id.editPrice ),
                        childAtPosition(
                                childAtPosition(
                                        withId( R.id.price ),
                                        0 ),
                                1 ),
                        isDisplayed() ) );
        appCompatEditText14.perform( replaceText( "89" ), closeSoftKeyboard() );

        ViewInteraction appCompatEditText15 = onView(
                allOf( withId( R.id.editQuantity ),
                        childAtPosition(
                                childAtPosition(
                                        withId( R.id.edtQuantity ),
                                        0 ),
                                1 ),
                        isDisplayed() ) );
        appCompatEditText15.perform( replaceText( "89" ), closeSoftKeyboard() );

        ViewInteraction appCompatButton3 = onView(
                allOf( withId( R.id.savebtn ), withText( "save" ),
                        childAtPosition(
                                allOf( withId( R.id.addform ),
                                        childAtPosition(
                                                withId( R.id.design_bottom_sheet ),
                                                0 ) ),
                                3 ),
                        isDisplayed() ) );
        appCompatButton3.perform( click() );

        ViewInteraction appCompatButton4 = onView(
                allOf( withId( R.id.savebtn ), withText( "save" ),
                        childAtPosition(
                                allOf( withId( R.id.addform ),
                                        childAtPosition(
                                                withId( R.id.design_bottom_sheet ),
                                                0 ) ),
                                3 ),
                        isDisplayed() ) );
        appCompatButton4.perform( click() );

        ViewInteraction editText = onView(
                allOf( withId( R.id.editItem ), withText( "grocery name" ),
                        withParent( withParent( withId( R.id.itemName ) ) ),
                        isDisplayed() ) );
        editText.check( matches( withText( "grocery name" ) ) );

        ViewInteraction editText2 = onView(
                allOf( withId( R.id.editItem ), withText( "grocery name" ),
                        withParent( withParent( withId( R.id.itemName ) ) ),
                        isDisplayed() ) );
        editText2.check( matches( withText( "grocery name" ) ) );
    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText( "Child at position " + position + " in parent " );
                parentMatcher.describeTo( description );
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches( parent )
                        && view.equals( ((ViewGroup) parent).getChildAt( position ) );
            }
        };
    }
}
