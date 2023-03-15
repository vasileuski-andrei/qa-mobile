package com.alfabank.qapp.test;

import static org.junit.Assert.assertTrue;

import com.alfabank.qapp.driver.DriverSingleton;
import com.alfabank.qapp.page.BasePage;
import com.alfabank.qapp.page.LoginPage;
import com.alfabank.qapp.util.ValidationInputData;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseTest {
    protected WebDriver driver;
    protected LoginPage loginPage;
    public static final String DEV_NAME = "samsung SM-J730F";
    private static final String APK_PATH = "/app/src/androidTest/resources/apk/app.apk";
    private static final String URL = "http://127.0.0.1:4723/wd/hub";
    public static final String USERNAME = "Username";
    public static final String PASSWORD = "Password";
    public static final String TOO_SHORT_DATA = ValidationInputData.getRandomString("ABCDEFHIJKLMNabcdefghijkuvwxyz\\s.,/'_-", 2);
    public static final String TOO_LONG_DATA = ValidationInputData.getRandomString("ABCDEFHIJKLMNabcdefghijkuvwxyz\\s.,/'_-", 54);
    public static final String INCORRECT_DATA = ValidationInputData.getRandomString("!@#$%^&*()1234567890", 25);
    protected static final Logger log = LoggerFactory.getLogger(BaseTest.class);

    @Before
    public void setup() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, DEV_NAME);
        desiredCapabilities.setCapability(MobileCapabilityType.APP,getAbsolutePath(APK_PATH));

        try {
            driver = DriverSingleton.getDriver(URL, desiredCapabilities);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } catch (MalformedURLException e) {
            log.info(e.getMessage());
        }

        loginPage = new LoginPage();

    }

    private String getAbsolutePath(String filePath) {
        File file = new File(filePath);
        assertTrue(filePath + " not found", file.exists());

        return file.getAbsolutePath();
    }
}
