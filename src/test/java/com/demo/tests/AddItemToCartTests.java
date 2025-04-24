package com.demo.tests;

import com.demo.data.UserData;
import com.demo.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddItemToCartTests extends TestBase {

    @BeforeMethod
    public void preconditions() {
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginForm(new User().setEmail(UserData.EMAIL).setPassword(UserData.PASSWORD));
        app.getUser().clickOnLoginButton();
    }

    @Test
    public void addFirstItemToCartTest() {
        String expectedProductName = app.getAddItemToCar().getProductNameById("31");
        app.getAddItemToCar().addToCartFromMainPageById("31");
        app.getAddItemToCar().closeNotificationBar();
        app.getAddItemToCar().openCart();
        String actualProductName = app.getAddItemToCar().getProductNameFromCart();
        Assert.assertEquals(actualProductName, expectedProductName);
    }

    @Test
    public void addSecondItemToCartTest() {
        String expectedProductName = app.getAddItemToCar().getProductNameById("72");
        app.getAddItemToCar().openProductDetailsPageById("72");
        app.getAddItemToCar().addToCartFromDetailsPageById("72");
        app.getAddItemToCar().closeNotificationBar();
        app.getAddItemToCar().openCart();
        Assert.assertTrue(app.getAddItemToCar().isProductInCart(expectedProductName));
    }


}
