package com.alfabank.qapp.page;

import com.alfabank.qapp.driver.DriverSingleton;
import com.alfabank.qapp.util.WaitingForEvents;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.appium.java_client.android.AndroidDriver;

public class BasePage {

    protected AndroidDriver driver;
    protected WaitingForEvents waitingForEvents;
    protected static final Logger log = LoggerFactory.getLogger(BasePage.class);

    public BasePage() {
        driver = DriverSingleton.getDriver();
        waitingForEvents = new WaitingForEvents(driver);
    }
}
