package com.ait.qa55;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @Test
    public void loginPositiveTest() {
        clickOnLoginLink();
        fillLoginForm(new User().setEmail("hatip45779@insfou.com").setPassword("Aa!12345"));
        clickOnLoginButton();
        Assert.assertTrue(isLogoutPresent());
    }

    @Test
    public void loginNegativeWithoutEmailTest() {
        clickOnLoginLink();
        fillLoginForm(new User().setPassword("Aa!12345"));
        clickOnLoginButton();
        Assert.assertTrue(isErrorMessageLoginPresent());
    }

}
