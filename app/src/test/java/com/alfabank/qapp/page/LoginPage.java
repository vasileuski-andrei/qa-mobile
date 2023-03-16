package com.alfabank.qapp.page;

import com.alfabank.qapp.util.ValidationInputData;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;;

public class LoginPage extends BasePage {

    @AndroidFindBy(id = "com.alfabank.qapp:id/tvTitle")
    private MobileElement title;

    @AndroidFindBy(id = "com.alfabank.qapp:id/etUsername")
    private MobileElement loginField;

    @AndroidFindBy(id = "com.alfabank.qapp:id/etPassword")
    private MobileElement passwordField;

    @AndroidFindBy(id = "com.alfabank.qapp:id/btnConfirm")
    private MobileElement buttonConfirm;

    @AndroidFindBy(id = "com.alfabank.qapp:id/tvError")
    private MobileElement errorMessage;

    public String getTitleText() {
        return waitingForEvents.waitForAppearanceElementAndGetIt(title).getText();
    }

    public LoginPage inputCredentials(String username, String password) {
        inputLogin(username);
        inputPassword(password);

        return this;
    }

    public void inputLogin(String username) {
        String checkedUsername = username;
        waitingForEvents.waitForAppearanceElement(loginField);
        boolean isUsernameValid = ValidationInputData.areSymbolsValid(username);

        if (!isUsernameValid) {
            checkedUsername = ValidationInputData.replaceAllInvalidSymbols(username);
        }

        loginField.sendKeys(checkedUsername);
        log.info("Username was successfully entered");

    }

    public boolean inputPassword(String password) {
        if (password.length() < 3) return false;
        String checkedPassword = password;
        waitingForEvents.waitForAppearanceElement(passwordField);
        boolean isPasswordValid = ValidationInputData.areSymbolsValid(password);

        if (!isPasswordValid) {
            checkedPassword = ValidationInputData.replaceAllInvalidSymbols(password);
        }

        passwordField.sendKeys(password);
        log.info("Password was successfully entered");

        return true;
    }

    public ProfilePage clickLoginButton() {
        waitingForEvents.waitForAppearanceElementAndClickIt(buttonConfirm);
        log.info("ProfilePage was opened");

        return new ProfilePage();
    }

    public String clickLoginButtonWithIncorrectCredentials() {
        waitingForEvents.waitForAppearanceElementAndClickIt(buttonConfirm);

        return waitingForEvents.waitForAppearanceElementAndGetIt(errorMessage).getText();
    }

}
