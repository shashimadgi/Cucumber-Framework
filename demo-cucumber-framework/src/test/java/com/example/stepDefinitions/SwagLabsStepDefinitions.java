package com.example.stepDefinitions;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class SwagLabsStepDefinitions {

    WebDriver driver;
    WebDriverWait wait;

    @Given("I navigate to the Swag Labs login page")
    public void iNavigateToTheLoginPage() {
        // Automatically setup the appropriate ChromeDriver version
        WebDriverManager.chromedriver().setup();

        // Initialize WebDriver and WebDriverWait
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // Navigate to the Swag Labs login page
        driver.get("https://www.saucedemo.com");
    }


    @When("I login with username {string} and password {string}")
    public void iLoginWithUsernameAndPassword(String username, String password) {
        driver.findElement(By.cssSelector("[data-test='username']")).sendKeys(username);
        driver.findElement(By.cssSelector("[data-test='password']")).sendKeys(password);
        driver.findElement(By.cssSelector("[data-test='login-button']")).click();
    }

    @And("I add {string} to the cart")
    public void iAddItemToCart(String itemName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='" + itemName + "']/ancestor::div[@class='inventory_item']//button")));
        driver.findElement(By.xpath("//div[text()='" + itemName + "']/ancestor::div[@class='inventory_item']//button")).click();
    }

    @And("I proceed to checkout")
    public void iProceedToCheckout() {
        driver.findElement(By.cssSelector(".shopping_cart_link")).click();
        driver.findElement(By.cssSelector("[data-test='checkout']")).click();
    }

    @And("I fill the checkout details with first name {string}, last name {string}, and postal code {string}")
    public void iFillCheckoutDetails(String firstName, String lastName, String postalCode) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-test='firstName']")));
        driver.findElement(By.cssSelector("[data-test='firstName']")).sendKeys(firstName);
        driver.findElement(By.cssSelector("[data-test='lastName']")).sendKeys(lastName);
        driver.findElement(By.cssSelector("[data-test='postalCode']")).sendKeys(postalCode);
        driver.findElement(By.cssSelector("[data-test='continue']")).click();
    }

    @And("I complete the order")
    public void iCompleteTheOrder() {
        driver.findElement(By.cssSelector("[data-test='finish']")).click();
    }

    @Then("I verify the order completion message")
    public void iVerifyTheOrderCompletionMessage() {
        WebElement thankYouMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".complete-header")));
        assert thankYouMessage.getText().equals("Thank you for your order!");
        driver.quit();
    }
}
