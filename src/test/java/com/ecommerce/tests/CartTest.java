package com.ecommerce.tests;

import com.ecommerce.base.BaseTest;
import com.ecommerce.pages.LoginPage;
import com.ecommerce.pages.ProductsPage;
import com.ecommerce.pages.CartPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.stream.Collectors;

public class CartTest extends BaseTest {

    @Test(description = "TestCase03: Add to Cart Functionality")
    public void testAddToCartFunctionality() {
        // Log in first.
        driver.get(baseUrl);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("testuser", "password123");
        
        ProductsPage productsPage = new ProductsPage(driver);
        CartPage cartPage = new CartPage(driver);
        
        // Add the first three products to the cart.
        productsPage.addProductsToCart(3);

        // Verify the cart item count on the product page.
        Assert.assertEquals(productsPage.getCartItemCount(), 3, "Cart item count is incorrect.");
        
        // Go to the cart page.
        productsPage.goToCart();
        
        // Verify the products are in the cart.
        List<WebElement> cartItems = cartPage.getCartItems();
        List<String> cartItemNames = cartItems.stream().map(WebElement::getText).collect(Collectors.toList());
        
        Assert.assertTrue(cartItemNames.contains("Stylish Jacket"), "Jacket not found in cart.");
        Assert.assertTrue(cartItemNames.contains("Denim Jeans"), "Jeans not found in cart.");
        Assert.assertTrue(cartItemNames.contains("Running Shoes"), "Shoes not found in cart.");
        
        System.out.println("Cart Test Passed: Products were correctly added to the cart.");
    }
}
