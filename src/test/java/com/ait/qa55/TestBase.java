package com.ait.qa55;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestBase {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod(enabled = false)
    public void tearDown() {
        driver.quit();
    }

    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }

    public void type(By locator, String text) {
        if (text != null) {
            click(locator);
            driver.findElement(locator).clear();
            driver.findElement(locator).sendKeys(text);
        }
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void clickOnRegisterButton() {
        click(By.id("register-button"));
    }

    public void fillRegisterForm(RegistrationUser registrationUser) {
        type(By.id("FirstName"), registrationUser.getFirstName());
        type(By.id("LastName"), registrationUser.getLastName());
        type(By.id("Email"), registrationUser.getEmail());
//        type(By.id("Email"), "test" + i + "@test.com");
        type(By.id("Password"), registrationUser.getPassword());
        type(By.id("ConfirmPassword"), registrationUser.getConfirmPassword());
    }

    public void fillLoginForm(User user) {
        type(By.id("Email"), user.getEmail());
        type(By.id("Password"), user.getPassword());
    }

    public void clickOnRegisterLink() {
        click(By.cssSelector("[href*='/register']"));
    }

    public boolean isRegisterPresent() {
        return isElementPresent(By.xpath("//h1[text()='Register']"));
    }

    public boolean isErrorMessageRegistrationPresent() {
        return isElementPresent(By.xpath("//li[text()='The specified email already exists']"));
    }

    public boolean isLogoutPresent() {
        return isElementPresent(By.xpath("//a[text()='Log out']"));
    }

    public void clickOnLoginButton() {
        click(By.xpath("//input[@class='button-1 login-button']"));
    }


    public void clickOnLoginLink() {
        click(By.cssSelector("[href*='/login']"));
    }

    public boolean isErrorMessageLoginPresent() {
        return isElementPresent(By.xpath("//span[text()='Login was unsuccessful. Please correct the errors and try again.']"));

    }
}
