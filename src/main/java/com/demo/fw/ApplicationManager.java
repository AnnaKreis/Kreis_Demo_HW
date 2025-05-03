package com.demo.fw;

import com.demo.utils.MyListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class ApplicationManager {
    String browser;
    WebDriver driver;
    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);

    UserHelper user;
    RegistrationUserHelper registrationUser;
    AddItemToCarHelper addItemToCar;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }


    public void init() {
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
            logger.info("Test start in Chrome browser");
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
            logger.info("Test start in Firefox browser");
        }
        WebDriverListener listener = new MyListener();
        driver = new EventFiringDecorator<>(listener).decorate(driver);
        driver.get("https://demowebshop.tricentis.com");
        logger.info("Current url -> " + driver.getCurrentUrl());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        user = new UserHelper(driver);
        registrationUser = new RegistrationUserHelper(driver);
        addItemToCar = new AddItemToCarHelper(driver);
    }

    public void stop() {
        driver.quit();
    }

    public UserHelper getUser() {
        return user;
    }

    public RegistrationUserHelper getRegistrationUser() {
        return registrationUser;
    }

    public AddItemToCarHelper getAddItemToCar() {
        return addItemToCar;
    }
}
