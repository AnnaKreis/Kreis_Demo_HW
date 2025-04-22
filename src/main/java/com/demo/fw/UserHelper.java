package com.demo.fw;

import com.demo.models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends BaseHelper {

    public UserHelper(WebDriver driver) {
        super(driver);
    }

    public void fillLoginForm(User user) {
        type(By.id("Email"), user.getEmail());
        type(By.id("Password"), user.getPassword());
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
