package com.ait.qa55;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

    @Test(enabled = false)
    public void newUserRegistrationPositiveTest() {
        int i = (int) ((System.currentTimeMillis() / 1000) % 3600);
        clickOnRegisterLink();
        fillRegisterForm(new RegistrationUser()
                .setFirstName("Helen")
                .setLastName("Straus")
                .setEmail("test" + i + "@test.com")
                .setPassword("Aa!12345")
                .setConfirmPassword("Aa!12345"));
        clickOnRegisterButton();
        Assert.assertTrue(isRegisterPresent());
    }

    @Test
    public void existedUserRegistrationNegativeTest() {
        clickOnRegisterLink();
        fillRegisterForm(new RegistrationUser()
                .setFirstName("Helen")
                .setLastName("Straus")
                .setEmail("hatip45779@insfou.com")
                .setPassword("Aa!12345")
                .setConfirmPassword("Aa!12345"));
        clickOnRegisterButton();
        Assert.assertTrue(isErrorMessageRegistrationPresent());
    }


}
