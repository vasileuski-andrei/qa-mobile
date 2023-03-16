package com.alfabank.qapp.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class LoginTest extends BaseTest {

    @Test
    public void successfulAuthorizationTest() {

        boolean actual = loginPage
                .inputCredentials(USERNAME, PASSWORD)
                .clickLoginButton()
                .isProfilePageOpened();

        assertTrue("Profile Page wasn't opened", actual);

    }

    @Test
    public void loginIsTooLongTest() {

        String actual = loginPage
                .inputCredentials(LONG_VALID_DATA, PASSWORD)
                .clickLoginButtonWithIncorrectCredentials();

        assertEquals(INVALID_CRED_ERROR_MESSAGE, actual);

    }

    @Test
    public void passwordIsTooLongTest() {

        String actual = loginPage
                .inputCredentials(USERNAME, LONG_VALID_DATA)
                .clickLoginButtonWithIncorrectCredentials();

        assertEquals(INVALID_CRED_ERROR_MESSAGE, actual);

    }

    @Test
    public void clickLoginButtonWithoutCredentialsTest() {

        String actual = loginPage
                .clickLoginButtonWithIncorrectCredentials();

        assertEquals(INVALID_CRED_ERROR_MESSAGE, actual);

    }

    @Test
    public void titleIsPresentTest() {

        String expected = "Вход в Alfa-Test";

        String actual = loginPage.getTitleText();

        assertEquals("Title " + expected + " isn't present in the login page", expected, actual);

    }

}
