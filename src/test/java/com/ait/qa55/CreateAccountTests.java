package com.ait.qa55;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

    @Test(enabled = false)
    public void newUserRegistrationPositiveTest() {
        int i = (int) ((System.currentTimeMillis() / 1000) % 3600);
        clickOnRegisterLink();
        fillRegisterForm1(i);
        clickOnRegisterButton();
        Assert.assertTrue(isRegisterPresent());
    }

    @Test
    public void existedUserRegistrationNegativeTest() {
        clickOnRegisterLink();
        fillRegisterForm2();
        clickOnRegisterButton();
        Assert.assertTrue(isErrorMessagePresent());
    }

}
