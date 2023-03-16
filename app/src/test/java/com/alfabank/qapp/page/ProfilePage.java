package com.alfabank.qapp.page;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ProfilePage extends BasePage {

    @AndroidFindBy(xpath = "//*[@id=\"selectedElementContainer\"]//span[text()='Вход в Alfa-Test выполнен']")
    private MobileElement confirmText;

    public boolean isProfilePageOpened() {
        return waitingForEvents.isElementPresent(confirmText);
    }
}
