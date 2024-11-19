package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    // Locators
    private By usernameTextbox = By.cssSelector("#user-name");
    private By passwordTextbox = By.cssSelector("#password");
    private By loginButton = By.cssSelector("#login-button");

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Methods
    public void gotoLoginPage() {
        driver.get("https://www.saucedemo.com/v1/");
    }

    public void login(String username, String password) {
        driver.findElement(usernameTextbox).sendKeys(username);
        driver.findElement(passwordTextbox).sendKeys(password);
        driver.findElement(loginButton).click();
    }
}
