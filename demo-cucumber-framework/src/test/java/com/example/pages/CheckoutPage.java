package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private final By firstNameField = By.cssSelector("[data-test='firstName']");
    private final By lastNameField = By.cssSelector("[data-test='lastName']");
    private final By postalCodeField = By.cssSelector("[data-test='postalCode']");
    private final By continueButton = By.cssSelector("[data-test='continue']");
    private final By finishButton = By.cssSelector("[data-test='finish']");
    private final By successMessage = By.tagName("h2");

    // Constructor
    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    // Helper method to wait for visibility of an element
    private WebElement waitForVisibility(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // Helper method to wait for element to be clickable
    private WebElement waitForClickability(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    // Method to fill checkout details
    public void fillCheckoutDetails(String firstName, String lastName, String postalCode) {
        try {
            if (firstName == null || firstName.isEmpty() ||
                lastName == null || lastName.isEmpty() ||
                postalCode == null || postalCode.isEmpty()) {
                throw new IllegalArgumentException("All checkout details must be provided.");
            }
            waitForVisibility(firstNameField).sendKeys(firstName);
            waitForVisibility(lastNameField).sendKeys(lastName);
            waitForVisibility(postalCodeField).sendKeys(postalCode);
            waitForClickability(continueButton).click();
            System.out.println("Checkout details filled successfully.");
        } catch (Exception e) {
            System.err.println("Failed to fill checkout details: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Method to finish checkout
    public void finishCheckout() {
        try {
            waitForClickability(finishButton).click();
            System.out.println("Checkout finished successfully.");
        } catch (Exception e) {
            System.err.println("Failed to click the Finish button: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Method to get the success message
    public String getSuccessMessage() {
        try {
            WebElement successMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
            String message = successMessageElement.getText();
            System.out.println("Success message found: " + message);
            return message;
        } catch (Exception e) {
            System.err.println("Failed to retrieve the success message: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    
    
    }
}
