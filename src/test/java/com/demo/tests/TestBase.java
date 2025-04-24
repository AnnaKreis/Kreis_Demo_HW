package com.demo.tests;

import com.demo.fw.ApplicationManager;
import org.openqa.selenium.remote.Browser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class TestBase {
    Logger logger = LoggerFactory.getLogger(TestBase.class);

    protected static ApplicationManager app = new ApplicationManager(System.getProperty("browser",
            Browser.CHROME.browserName()));

//    @BeforeMethod
    @BeforeSuite
    public void setUp() {
        app.init();

    }
    @BeforeMethod
    public void cleanState() {
        app.getAddItemToCar().clearCart();
        app.getUser().logout();
    }

//    @AfterMethod(enabled = false)
    @AfterSuite
    public void tearDown() {
        app.stop();
    }
    @BeforeMethod
    public void startTest(){
        logger.info("Start test");
    }

    @AfterMethod
    public void stopTest(){
        logger.info("Stop test");
    }

}
