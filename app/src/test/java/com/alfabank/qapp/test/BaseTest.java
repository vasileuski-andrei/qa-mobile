package com.alfabank.qapp.test;

import com.alfabank.qapp.driver.DriverSingleton;
import com.alfabank.qapp.page.LoginPage;
import com.alfabank.qapp.util.ValidationInputData;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.net.MalformedURLException;

import io.appium.java_client.remote.MobileCapabilityType;

public class BaseTest {
    protected WebDriver driver;
    protected LoginPage loginPage;
    public static final String DEV_NAME = "Pixel 2 API 24";
    private static final String APK_PATH = "src/test/resources/apk/app.apk";
    private static final String URL = "http://127.0.0.1:4723/wd/hub";
    public static final String USERNAME = "Login";
    public static final String PASSWORD = "Password";
    public static final String INVALID_CRED_ERROR_MESSAGE = "Введены неверные данные";
    public static final String LONG_VALID_DATA = ValidationInputData.getRandomString("ABCDEFHIJKLMNabcdefghijkuvwxyz\\s.,/'_-", 54);
    public static final String INVALID_DATA = ValidationInputData.getRandomString("!@#$%^&*()1234567890", 15);
    protected static final Logger log = LoggerFactory.getLogger(BaseTest.class);
    DesiredCapabilities desiredCapabilities = null;

    @BeforeEach
    public void setup() {
        desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, DEV_NAME);
        desiredCapabilities.setCapability(MobileCapabilityType.APP,getAbsolutePath(APK_PATH));

        try {
            driver = DriverSingleton.getDriver(URL, desiredCapabilities);
//            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        } catch (MalformedURLException e) {
            log.info(e.getMessage());
        }

        loginPage = new LoginPage();

    }

    private String getAbsolutePath(String filePath) {
        File file = new File(filePath);
        Assertions.assertTrue(file.exists(), filePath + " not found");

        return file.getAbsolutePath();
    }

    @AfterEach
    public void close() {
        DriverSingleton.closeDriver();
    }

}
