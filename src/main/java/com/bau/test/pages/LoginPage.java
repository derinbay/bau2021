package com.bau.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {

    By loginEmailLocator = By.cssSelector("#login-email");
    By loginPasswordLocator = By.cssSelector("#login-password-input");
    By loginButtonLocator = By.cssSelector(".submit");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public Homepage login() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        sendKeys(loginEmailLocator, "user email");
        sendKeys(loginPasswordLocator, "user password");
        click(loginButtonLocator);

        wait.until(ExpectedConditions.urlToBe("https://www.trendyol.com/butik/liste/2/erkek"));

        return new Homepage(driver);
    }
}
