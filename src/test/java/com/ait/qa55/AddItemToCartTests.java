package com.ait.qa55;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class AddItemToCartTests extends TestBase {

    @BeforeMethod
    public void preconditions() {
        clickOnLoginLink();
        fillLoginForm(new User().setEmail("hatip45779@insfou.com").setPassword("Aa!12345"));
        clickOnLoginButton();
    }

    @Test
    public void addFirstItemToCartTest() {
        WebElement productBlock = driver.findElement(By.cssSelector("div.product-item[data-productid='31']"));
        WebElement productTitleLink = productBlock.findElement(By.cssSelector("h2.product-title a"));
        String expectedProductName = productTitleLink.getText();
//        System.out.println("Adding product: " + expectedProductName);
        WebElement addToCartButton = productBlock.findElement(By.cssSelector("input[value='Add to cart']"));
        addToCartButton.click();
        WebElement notificationCloseBtn = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector("#bar-notification .close")));
        notificationCloseBtn.click();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.invisibilityOfElementLocated(By.id("bar-notification")));
        click(By.cssSelector("span.cart-label"));
        WebElement productInCart = driver.findElement(By.cssSelector("td.product a.product-name"));
        String actualProductName = productInCart.getText();
//        System.out.println("Product in cart: " + actualProductName);
        Assert.assertEquals(actualProductName, expectedProductName);
    }
    @Test
    public void addSecondItemToCartTest() {
        WebElement productBlock = driver.findElement(By.cssSelector("div.product-item[data-productid='72']"));
        WebElement productTitleLink = productBlock.findElement(By.cssSelector("h2.product-title a"));
        String expectedProductName = productTitleLink.getText();
        System.out.println("Adding second product: " + expectedProductName);
        WebElement addToCartButton = productBlock.findElement(By.cssSelector("input.button-2.product-box-add-to-cart-button"));
        addToCartButton.click();
        WebElement addToCartButtonInDetailPage = driver.findElement(By.cssSelector("input#add-to-cart-button-72"));
        addToCartButtonInDetailPage.click();
        WebElement notificationCloseBtn = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector("#bar-notification .close")));
        notificationCloseBtn.click();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.invisibilityOfElementLocated(By.id("bar-notification")));
        click(By.cssSelector("span.cart-label"));
        List<WebElement> productNamesInCart = driver.findElements(By.cssSelector("td.product a.product-name"));
        boolean productFound = productNamesInCart.stream()
                .anyMatch(el -> el.getText().equals(expectedProductName));
        Assert.assertTrue(productFound);
    }

}
