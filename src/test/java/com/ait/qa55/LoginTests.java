package com.ait.qa55;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @Test
    public void loginPositiveTest() {
        clickOnLoginLink();
        fillLoginForm();
        clickOnLoginButton();
        Assert.assertTrue(isLogoutPresent());

    }

    //    @Test
//    public void loginNegativeWithoutEmailTest() {
//        //click on Login Link
//        click(By.cssSelector("[href*='/login']"));
//        //enter Email to mail field
//        type(By.id("Email"), "hatip45779@insfou.com");
//        //enter Password to password field
//        type(By.id("Password"), "Aa!12345");
//        //click on Login button
//        click(By.xpath("//input[@class='button-1 login-button']"));
//        Assert.assertTrue(isElementPresent(By.xpath("//a[text()='Log out']")));

//    }

}
