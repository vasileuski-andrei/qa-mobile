package com.alfabank.qapp.driver;

import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.android.AndroidDriver;

public class DriverSingleton {

    private static AndroidDriver driver;

    private DriverSingleton() {}

    public static AndroidDriver getDriver(String url, DesiredCapabilities desiredCapabilities) throws MalformedURLException {

        if (driver == null) {
            driver = new AndroidDriver(new URL(url), desiredCapabilities);
        }

        return driver;
    }

    public static AndroidDriver getDriver() {
        return driver;
    }

    public static void closeDriver() {
        driver.quit();
        driver = null;
    }

}
