package com.ecommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class CartPage {
    private WebDriver driver;

    // Locators for elements on the cart page
    private By cartItemNames = By.cssSelector(".cart-item .item-name");
    private By checkoutButton = By.id("checkoutBtn");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    // Methods to interact with the page elements
    public List<WebElement> getCartItems() {
        return driver.findElements(cartItemNames);
    }

    public void clickCheckout() {
        driver.findElement(checkoutButton).click();
    }
}
