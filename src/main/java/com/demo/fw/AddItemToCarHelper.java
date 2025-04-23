package com.demo.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AddItemToCarHelper extends BaseHelper {

    public AddItemToCarHelper(WebDriver driver) {
        super(driver);
    }

    public void clearCart() {
        if (isElementPresent(By.cssSelector("span.cart-label"))) {
            // Переходим в корзину
            click(By.cssSelector("span.cart-label"));
            // Удаляем все товары из корзины
            while (isElementPresent(By.cssSelector("button.remove"))){
                click(By.cssSelector("button.remove"));
            }
        }
    }

    public String getProductNameById(String productId) {
        return driver.findElement(By.cssSelector("div.product-item[data-productid='" + productId + "']"))
                .findElement(By.cssSelector("h2.product-title a"))
                .getText();
    }

    public void addToCartFromMainPageById(String productId) {
        WebElement productBlock = driver.findElement(By.cssSelector("div.product-item[data-productid='" + productId + "']"));
        WebElement addToCartButton = productBlock.findElement(By.cssSelector("input[value='Add to cart']"));
        addToCartButton.click();
    }

    public void openProductDetailsPageById(String productId) {
        WebElement productBlock = driver.findElement(By.cssSelector("div.product-item[data-productid='" + productId + "']"));
        WebElement productTitleLink = productBlock.findElement(By.cssSelector("h2.product-title a"));
        productTitleLink.click();
    }

    public void addToCartFromDetailsPageById(String productId) {
        click(By.cssSelector("input#add-to-cart-button-" + productId));
    }

    public void closeNotificationBar() {
        WebElement closeBtn = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector("#bar-notification .close")));
        closeBtn.click();

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.invisibilityOfElementLocated(By.id("bar-notification")));
    }

    public void openCart() {
        click(By.cssSelector("span.cart-label"));
    }

    public String getProductNameFromCart() {
        return driver.findElement(By.cssSelector("td.product a.product-name")).getText();
    }

    public boolean isProductInCart(String expectedProductName) {
        List<WebElement> productNamesInCart = driver.findElements(By.cssSelector("td.product a.product-name"));
        return productNamesInCart.stream().anyMatch(el -> el.getText().equals(expectedProductName));
    }
}
