package com.alfabank.qapp.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class LoginTest extends BaseTest {

    @Test
    public void titleIsPresentTest() {

        boolean actualResult = loginPage.isTitlePresent();

        assertTrue("Title isn't present in the login page", actualResult);

    }

    @Test
    public void successfulAuthorizationTest() {

        boolean actualResult = loginPage
                .inputCredentials(USERNAME, PASSWORD)
                .clickLoginButton()
                .isProfilePageOpened();

        assertTrue("Profile Page wasn't opened", actualResult);

    }

    @Test
    public void loginIsTooShortTest() {

        boolean actualResult = loginPage.inputLogin(TOO_SHORT_DATA);

        assertFalse(actualResult);

    }

    @Test
    public void loginIsTooLongTest() {

        boolean actualResult = loginPage.inputLogin(TOO_LONG_DATA);

        assertFalse(actualResult);

    }

    @Test
    public void replaceAllIncorrectSymbolsTest() {

        String actualResult = loginPage.replaceAllIncorrectSymbols(INCORRECT_DATA);

        assertEquals("", actualResult);

    }

}
