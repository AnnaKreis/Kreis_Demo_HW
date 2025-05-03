package com.demo.tests;

import com.demo.data.RegistrationUserData;
import com.demo.models.RegistrationUser;
import com.demo.utils.DataProviders;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

//    @Test(dataProvider = "registration", dataProviderClass = DataProviders.class)
//    public void newUserRegistrationPositiveFromDataProviderTest(String firstName, String lastName,
//                                                                String email, String password,
//                                                                String confirmPassword) {
//        app.getRegistrationUser().clickOnRegisterLink();
//        app.getRegistrationUser().fillRegisterForm(new RegistrationUser()
//                .setFirstName(firstName)
//                .setLastName(lastName)
////                .setEmail(RegistrationUserData.getDynamicEmail())
//                .setEmail(email)
//                .setPassword(password)
//                .setConfirmPassword(confirmPassword));
//        app.getRegistrationUser().clickOnRegisterButton();
//        Assert.assertTrue(app.getRegistrationUser().isRegisterPresent());
//    }

    @Test(dataProvider = "registrationWithCsv", dataProviderClass = DataProviders.class)
    public void newUserRegistrationPositiveFromDataProviderWithCsvFileTest(RegistrationUser registrationUser) {
        app.getRegistrationUser().clickOnRegisterLink();
        app.getRegistrationUser().fillRegisterForm(registrationUser);
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
