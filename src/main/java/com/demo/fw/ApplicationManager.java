package com.demo.fw;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ApplicationManager {
    WebDriver driver;

    UserHelper user;
    RegistrationUserHelper registrationUser;
    AddItemToCarHelper addItemToCar;


    public void init() {
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com");
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
