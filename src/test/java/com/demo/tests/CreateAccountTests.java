package com.demo.tests;

import com.demo.models.RegistrationUser;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

    @Test(enabled = false)
    public void newUserRegistrationPositiveTest() {
        int i = (int) ((System.currentTimeMillis() / 1000) % 3600);
        app.getRegistrationUser().clickOnRegisterLink();
        app.getRegistrationUser().fillRegisterForm(new RegistrationUser()
                .setFirstName("Helen")
                .setLastName("Straus")
                .setEmail("test" + i + "@test.com")
                .setPassword("Aa!12345")
                .setConfirmPassword("Aa!12345"));
        app.getRegistrationUser().clickOnRegisterButton();
        Assert.assertTrue(app.getRegistrationUser().isRegisterPresent());
    }

    @Test
    public void existedUserRegistrationNegativeTest() {
        app.getRegistrationUser().clickOnRegisterLink();
        app.getRegistrationUser().fillRegisterForm(new RegistrationUser()
                .setFirstName("Helen")
                .setLastName("Straus")
                .setEmail("hatip45779@insfou.com")
                .setPassword("Aa!12345")
                .setConfirmPassword("Aa!12345"));
        app.getRegistrationUser().clickOnRegisterButton();
        Assert.assertTrue(app.getRegistrationUser().isErrorMessageRegistrationPresent());
    }

}
