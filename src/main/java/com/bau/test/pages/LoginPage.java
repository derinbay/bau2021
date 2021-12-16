package com.bau.test.pages;

import com.bau.test.users.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {

    By loginEmailLocator = By.cssSelector("#login-email");
    By loginPasswordLocator = By.cssSelector("#login-password-input");
    By loginButtonLocator = By.cssSelector(".submit");
    By errorBoxLocator = By.id("error-box-wrapper");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public Homepage login(User user) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        sendKeys(loginEmailLocator, user.getEmail());
        sendKeys(loginPasswordLocator, user.getPassword());
        click(loginButtonLocator);

        wait.until(ExpectedConditions.urlToBe("https://www.trendyol.com/butik/liste/2/erkek"));

        return new Homepage(driver);
    }

    public LoginPage loginWithWrongPassword(User user) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        sendKeys(loginEmailLocator, user.getEmail());
        sendKeys(loginPasswordLocator, user.getPassword());
        click(loginButtonLocator);

        wait.until(ExpectedConditions.visibilityOfElementLocated(errorBoxLocator));

        return this;
    }

    public boolean isErrorBoxDisplayed() {
        return waitForVisibility(errorBoxLocator).isDisplayed();
    }

    public String getErrorBoxText() {
        return getText(errorBoxLocator);
    }
}
