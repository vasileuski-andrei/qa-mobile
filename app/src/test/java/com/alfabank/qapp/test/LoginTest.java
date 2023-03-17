package com.alfabank.qapp.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class LoginTest extends BaseTest {

    @Test
    public void titleIsPresentTest() {

        String expected = "Вход в Alfa-Test";

        String actual = loginPage.getTitleText();

        assertEquals("Title " + expected + " isn't present in the login page", expected, actual);

    }

    @Test
    public void successfulAuthorizationTest() {

        boolean actual = loginPage
                .inputLogin(USERNAME)
                .inputPassword(PASSWORD)
                .clickLoginButton()
                .isProfilePageOpened();

        assertTrue("Profile Page wasn't opened", actual);

    }

    @Test
    public void inputValidTooLongLoginTest() {

        String actual = loginPage
                .inputLogin(LONG_VALID_DATA)
                .inputPassword(PASSWORD)
                .clickLoginButtonWithIncorrectCredentials();

        assertEquals(INVALID_CRED_ERROR_MESSAGE, actual);

    }

    @Test
    public void inputInvalidLoginTest() {

        String actual = loginPage
                .inputLogin(INVALID_DATA)
                .inputPassword(PASSWORD)
                .clickLoginButtonWithIncorrectCredentials();

        assertEquals(INVALID_CRED_ERROR_MESSAGE, actual);

    }

    @Test
    public void inputValidTooLongPasswordTest() {

        String actual = loginPage
                .inputLogin(USERNAME)
                .inputPassword(LONG_VALID_DATA)
                .clickLoginButtonWithIncorrectCredentials();

        assertEquals(INVALID_CRED_ERROR_MESSAGE, actual);

    }

    @Test
    public void inputLoginWithoutPasswordTest() {

        String actual = loginPage
                .inputLogin(USERNAME)
                .clickLoginButtonWithIncorrectCredentials();

        assertEquals(INVALID_CRED_ERROR_MESSAGE, actual);

    }

    @Test
    public void clickLoginButtonWithoutCredentialsTest() {

        String actual = loginPage
                .clickLoginButtonWithIncorrectCredentials();

        assertEquals(INVALID_CRED_ERROR_MESSAGE, actual);

    }

}
