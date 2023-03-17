package com.alfabank.qapp.page;

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

    public LoginPage inputLogin(String username) {
        waitingForEvents.waitForAppearanceElement(loginField);
        loginField.sendKeys(username);
        log.info("Username was successfully entered");

        return this;
    }

    public void inputPassword(String password) {
        waitingForEvents.waitForAppearanceElement(passwordField);
        passwordField.sendKeys(password);
        log.info("Password was successfully entered");

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
