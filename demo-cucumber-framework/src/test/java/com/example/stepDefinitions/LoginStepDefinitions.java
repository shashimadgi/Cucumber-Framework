// package com.example.stepDefinitions;

// import io.cucumber.java.en.*;
// import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.chrome.ChromeDriver;
// import com.example.pages.LoginPage;
// import io.github.bonigarcia.wdm.WebDriverManager;

// public class LoginStepDefinitions {
//     WebDriver driver;
//     LoginPage loginPage;

//     @Given("I navigate to the login page")
//     public void iNavigateToTheLoginPage() {
//         // Use WebDriverManager to automatically manage ChromeDriver
//         WebDriverManager.chromedriver().setup();
//         driver = new ChromeDriver();
//         driver.manage().window().maximize();
//         loginPage = new LoginPage(driver);
//         loginPage.gotoLoginPage();
//     }

//     @When("I login with username {string} and password {string}")
//     public void iLoginWithUsernameAndPassword(String username, String password) {
//         loginPage.login(username, password);
//     }

//     @Then("I should be logged in successfully")
//     public void iShouldBeLoggedInSuccessfully() {
//         // Add your assertion logic here
//         // Example:
//         assert driver.getCurrentUrl().contains("saucedemo");
//         driver.quit();
    
//     }
//     @Given("I navigate to the products page")
//     public void iNavigateToProducts() {
//         // Use WebDriverManager to automatically manage ChromeDriver
        
       
//         addToCart.gotoLoginPage();
//     }
// }
