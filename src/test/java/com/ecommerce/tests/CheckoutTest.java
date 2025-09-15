package com.ecommerce.tests;

import com.ecommerce.base.BaseTest;
import com.ecommerce.pages.LoginPage;
import com.ecommerce.pages.ProductsPage;
import com.ecommerce.pages.CartPage;
import com.ecommerce.pages.CheckoutPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {

    @Test(description = "TestCase04: Checkout Functionality")
    public void testCheckoutProcess() {
        // Log in
        driver.get(baseUrl);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("testuser", "password123");

        ProductsPage productsPage = new ProductsPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        
        // Add an item to the cart.
        productsPage.addProductsToCart(1);
        
        // Go to cart page and click checkout.
        productsPage.goToCart();
        cartPage.clickCheckout();

        // Verify the checkout success message.
        String successMessage = checkoutPage.getSuccessMessage();
        Assert.assertTrue(successMessage.contains("Checkout Successful!"), "Checkout success message not displayed.");
        
        System.out.println("Checkout Test Passed: The checkout process completed successfully.");
    }
}
