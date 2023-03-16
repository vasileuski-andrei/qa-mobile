package com.alfabank.qapp.page;

import com.alfabank.qapp.driver.DriverSingleton;
import com.alfabank.qapp.util.WaitingForEvents;

import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class BasePage {

    protected AndroidDriver driver;
    protected WaitingForEvents waitingForEvents;
    protected static final Logger log = LoggerFactory.getLogger(BasePage.class);

    public BasePage() {
        driver = DriverSingleton.getDriver();
        waitingForEvents = new WaitingForEvents(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
}
