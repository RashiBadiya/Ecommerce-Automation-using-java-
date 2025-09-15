package com.ecommerce.tests;

import java.util.Collections;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ecommerce.base.BaseTest;
import com.ecommerce.pages.LoginPage;
import com.ecommerce.pages.ProductsPage;

public class FilterTest extends BaseTest {

    @Test
    public void testFilterByPriceAscending() {
        // Arrange
        driver.get(baseUrl);
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);

        // Act
        loginPage.login("testuser", "password123");
        productsPage.applyPriceFilter("asc");

        // Assert
        List<Double> productPrices = productsPage.getProductPrices();
        List<Double> sortedPrices = productPrices;
        Collections.sort(sortedPrices);
        Assert.assertEquals(productPrices, sortedPrices, "Products are not sorted by price in ascending order.");
        System.out.println("Test passed: Products are correctly filtered by price in ascending order.");
    }
}
