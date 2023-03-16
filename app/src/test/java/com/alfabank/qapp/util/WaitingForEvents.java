package com.alfabank.qapp.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

import io.appium.java_client.MobileElement;

public class WaitingForEvents {

    private static final int WAIT_TIMEOUT_SECONDS = 30;
    private WebDriver driver;
    private WebDriverWait wait;
    protected static final Logger log = LoggerFactory.getLogger(WaitingForEvents.class);

    public WaitingForEvents(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
    }

    public void waitForAppearanceElement(MobileElement element) {
        wait.withTimeout(Duration.ofSeconds(WAIT_TIMEOUT_SECONDS)).until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitForAppearanceElementAndGetIt(MobileElement element) {
        return wait.withTimeout(Duration.ofSeconds(WAIT_TIMEOUT_SECONDS)).until(ExpectedConditions.visibilityOf(element));
    }

    public boolean isElementPresent(MobileElement element) {
        boolean isPresent = false;
        try {
            wait.withTimeout(Duration.ofSeconds(WAIT_TIMEOUT_SECONDS)).until(ExpectedConditions.visibilityOf(element));
            isPresent = true;
        } catch (WebDriverException e) {
            log.info(e.getMessage());
        }
        return isPresent;
    }

}
