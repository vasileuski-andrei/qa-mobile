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

    public String getTitleText() {
        return waitingForEvents.waitForAppearanceElementAndGetIt(title).getText();
    }

    public LoginPage inputCredentials(String username, String password) {
        inputLogin(username);
        inputPassword(password);

        return this;
    }

    public boolean inputLogin(String username) {
        if (username.length() < 3) return false;
        String checkedUsername = username;
        waitingForEvents.waitForAppearanceElement(loginField);
        boolean isUsernameValid = ValidationInputData.areSymbolsValid(username);

        if (!isUsernameValid) {
            checkedUsername = ValidationInputData.replaceAllInvalidSymbols(username);
        }

        if (checkedUsername.length() > 50) return false;

        loginField.sendKeys(checkedUsername);
        log.info("Username was successfully entered");

        return true;
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
        waitingForEvents.waitForAppearanceElement(buttonConfirm);
        buttonConfirm.click();
        log.info("ProfilePage was opened");

        return new ProfilePage();
    }

    public String replaceAllIncorrectSymbols(String data) {
        return ValidationInputData.replaceAllInvalidSymbols(data);
    }

}
