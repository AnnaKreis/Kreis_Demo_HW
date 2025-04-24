package com.demo.tests;

import com.demo.data.RegistrationUserData;
import com.demo.models.RegistrationUser;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

    @Test(enabled = false)
    public void newUserRegistrationPositiveTest() {
//        int i = (int) ((System.currentTimeMillis() / 1000) % 3600);
        app.getRegistrationUser().clickOnRegisterLink();
        app.getRegistrationUser().fillRegisterForm(new RegistrationUser()
                .setFirstName(RegistrationUserData.FIRST_NAME)
                .setLastName(RegistrationUserData.LAST_NAME)
                .setEmail(RegistrationUserData.getDynamicEmail())
                .setPassword(RegistrationUserData.PASSWORD)
                .setConfirmPassword(RegistrationUserData.CONFIRM_PASSWORD));
        app.getRegistrationUser().clickOnRegisterButton();
        Assert.assertTrue(app.getRegistrationUser().isRegisterPresent());
    }

    @Test
    public void existedUserRegistrationNegativeTest() {
        app.getRegistrationUser().clickOnRegisterLink();
        app.getRegistrationUser().fillRegisterForm(new RegistrationUser()
                .setFirstName(RegistrationUserData.FIRST_NAME)
                .setLastName(RegistrationUserData.LAST_NAME)
                .setEmail(RegistrationUserData.EMAIL)
                .setPassword(RegistrationUserData.PASSWORD)
                .setConfirmPassword(RegistrationUserData.CONFIRM_PASSWORD));
        app.getRegistrationUser().clickOnRegisterButton();
        Assert.assertTrue(app.getRegistrationUser().isErrorMessageRegistrationPresent());
    }

}
