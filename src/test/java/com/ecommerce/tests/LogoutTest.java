package com.ecommerce.tests;

import com.ecommerce.base.BaseTest;
import com.ecommerce.pages.LoginPage;
import com.ecommerce.pages.ProductsPage;
import com.ecommerce.pages.LogoutPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest {

    @Test(description = "TestCase05: Verify Logout Functionality")
    public void testLogoutFunctionality() {
        // Step 1: Log in to the application
        driver.get(baseUrl);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("testuser", "password123");
        
        // Verify that login was successful by checking the URL
        ProductsPage productsPage = new ProductsPage(driver);
        Assert.assertTrue(productsPage.isProductsPageDisplayed(), "Login failed before testing logout.");
        
        System.out.println("Successfully logged in. Proceeding with logout test.");
        
        // Step 2: Perform the logout action
        LogoutPage logoutPage = new LogoutPage(driver);
        logoutPage.logout();
        
        // Step 3: Verify that the logout was successful by checking if we are back on the login page
        Assert.assertTrue(loginPage.isLoginPageDisplayed(), "Logout failed! User is not on the login page.");
        
        System.out.println("Logout Test Passed: Successfully logged out and redirected to login page.");
    }
}
