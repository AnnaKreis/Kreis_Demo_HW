package com.demo.fw;

import com.demo.models.RegistrationUser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationUserHelper extends BaseHelper {

    public RegistrationUserHelper(WebDriver driver) {
        super(driver);
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

    public void clickOnRegisterLink() {
        click(By.cssSelector("[href*='/register']"));
    }

    public boolean isRegisterPresent() {
        return isElementPresent(By.xpath("//h1[text()='Register']"));
    }

    public boolean isErrorMessageRegistrationPresent() {
        return isElementPresent(By.xpath("//li[text()='The specified email already exists']"));
    }
}
