package com.ecommerce.pages;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductsPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By headerTitle = By.tagName("h2");
    private By filterDropdown = By.id("priceFilter");
    private By productPrice = By.cssSelector(".product-price");
    private By addToCartButton = By.cssSelector(".add-to-cart-btn");
    private By cartBadge = By.className("cart-item-count");
    private By cartIcon = By.id("cartBtn");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean isProductsPageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(headerTitle)).getText().equals("Products");
    }

    public void applyFilterByPriceAsc() {
        Select filter = new Select(driver.findElement(filterDropdown));
        filter.selectByValue("price_asc");
    }

    public void applyPriceFilter(String filterValue) {
        Select filter = new Select(driver.findElement(filterDropdown));
        filter.selectByValue(filterValue);
    }

    public List<Double> getProductPrices() {
        List<WebElement> priceElements = driver.findElements(productPrice);
        return priceElements.stream()
                .map(e -> Double.parseDouble(e.getText().replace("$", "")))
                .collect(Collectors.toList());
    }

    public void addProductsToCart(int count) {
        List<WebElement> buttons = driver.findElements(addToCartButton);
        for (int i = 0; i < count; i++) {
            buttons.get(i).click();
        }
        // Wait for the cart count to be updated
        wait.until(ExpectedConditions.textToBe(cartBadge, String.valueOf(count)));
    }

    public int getCartItemCount() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartBadge));
        return Integer.parseInt(driver.findElement(cartBadge).getText());
    }

    public void goToCart() {
        driver.findElement(cartIcon).click();
    }
}
