package com.demo.tests;

import com.demo.data.RegistrationUserData;
import com.demo.data.UserData;
import com.demo.models.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @Test
    public void loginPositiveTest() {
        logger.info("Login with data -> " + UserData.EMAIL + "************" + UserData.PASSWORD);
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginForm(new User().setEmail(UserData.EMAIL).setPassword(UserData.PASSWORD));
        app.getUser().clickOnLoginButton();
        Assert.assertTrue(app.getUser().isLogoutPresent());
    }

    @Test
    public void loginNegativeWithoutEmailTest() {
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginForm(new User().setPassword(UserData.PASSWORD));
        app.getUser().clickOnLoginButton();
        Assert.assertTrue(app.getUser().isErrorMessageLoginPresent());
    }

}
