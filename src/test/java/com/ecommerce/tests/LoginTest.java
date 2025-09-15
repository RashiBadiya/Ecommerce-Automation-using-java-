package com.ecommerce.tests;

import com.ecommerce.base.BaseTest;
import com.ecommerce.pages.LoginPage;
import com.ecommerce.pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(description = "TestCase01: Verify Login Functionality with valid credentials")
    public void testLoginFunctionality() {
        // Navigate to the base URL
        driver.get(baseUrl);
        
        // Initialize the login page
        LoginPage loginPage = new LoginPage(driver);
        
        // Perform login with valid credentials
        loginPage.login("testuser", "password123");
        
        // Initialize the products page and verify the login was successful
        ProductsPage productsPage = new ProductsPage(driver);
        Assert.assertTrue(productsPage.isProductsPageDisplayed(), "Login failed! Products page is not displayed.");
        
        System.out.println("Login Test Passed: Successfully logged in with valid credentials.");
    }

    @Test(description = "TestCase01: Verify Login Functionality with invalid credentials")
    public void testLoginWithInvalidCredentials() {
        // Navigate to the base URL
        driver.get(baseUrl);
        
        // Initialize the login page
        LoginPage loginPage = new LoginPage(driver);
        
        // Perform login with invalid credentials
        loginPage.login("invaliduser", "wrongpassword");

        // Verify the error message
        String errorMessage = loginPage.getLoginErrorMessage();
        Assert.assertTrue(errorMessage.contains("Invalid username or password."), "Expected error message not displayed.");
        
        System.out.println("Login with Invalid Credentials Test Passed: Correct error message was displayed.");
    }
}
