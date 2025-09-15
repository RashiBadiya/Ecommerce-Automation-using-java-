package com.ecommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
    private WebDriver driver;

    // Locators for elements on the checkout page
    private By successMessage = By.id("checkoutSuccessMessage");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    // Method to get the success message
    public String getSuccessMessage() {
        return driver.findElement(successMessage).getText();
    }
}
