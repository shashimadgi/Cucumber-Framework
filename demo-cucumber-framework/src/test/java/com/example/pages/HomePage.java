package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private By cartLink = By.cssSelector("#shopping_cart_container a");

    // Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Explicit wait
    }

    // Method to generate a dynamic XPath locator for items
    private By getItemAddToCartButton(String itemName) {
        return By.xpath("//div[text()='" + itemName + "']/ancestor::div[@class='inventory_item']//button[contains(text(),'Add to cart')]");
    }

    // Method to add an item to the cart using XPath
    public void addItemToCart(String itemName) {
        try {
            WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(getItemAddToCartButton(itemName)));
            addToCartButton.click();
            System.out.println("Item '" + itemName + "' added to the cart successfully.");
        } catch (Exception e) {
            System.err.println("Failed to add item '" + itemName + "' to the cart: " + e.getMessage());
        }
    }

    // Method to navigate to the cart
    public void goToCart() {
        try {
            WebElement cartElement = wait.until(ExpectedConditions.elementToBeClickable(cartLink));
            cartElement.click();
            System.out.println("Navigated to the cart successfully.");
        } catch (Exception e) {
            System.err.println("Failed to navigate to the cart: " + e.getMessage());
        }
    }

    // Method to generate a dynamic CSS Selector for items
    private By getItemCheckoutButton(String itemName) {
        // The :has and :contains pseudo-classes are not supported directly in Selenium's CSS Selectors
        // Instead, find the item container and button using simplified selectors
        return By.cssSelector("div.inventory_item:has([data-test='" + itemName + "']) button");
    }

    // Method to add an item to the cart using a dynamic CSS Selector
    public void addItemCheckout(String itemName) {
        try {
            WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(getItemCheckoutButton(itemName)));
            addToCartButton.click();
            System.out.println("Item '" + itemName + "' added to the cart successfully.");
        } catch (Exception e) {
            System.err.println("Failed to add item '" + itemName + "' to the cart: " + e.getMessage());
        }
    }
}
