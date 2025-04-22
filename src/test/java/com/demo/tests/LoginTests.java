package com.demo.tests;

import com.demo.models.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @Test
    public void loginPositiveTest() {
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginForm(new User().setEmail("hatip45779@insfou.com").setPassword("Aa!12345"));
        app.getUser().clickOnLoginButton();
        Assert.assertTrue(app.getUser().isLogoutPresent());
    }

    @Test
    public void loginNegativeWithoutEmailTest() {
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginForm(new User().setPassword("Aa!12345"));
        app.getUser().clickOnLoginButton();
        Assert.assertTrue(app.getUser().isErrorMessageLoginPresent());
    }

}
