package com.bau.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.Keys.ENTER;

public class Homepage extends BasePage {

    By searchBoxLocator = By.cssSelector(".search-box");
    By accountLocator = By.cssSelector(".account-user");
    By accountLocatorText = By.cssSelector(".account-user > .link-text");

    public Homepage(WebDriver driver) {
        super(driver);
    }

    public LoginPage goToLoginPage() {
        driver.findElement(accountLocator).click();
        return new LoginPage(driver);
    }

    public String getAccountText() {
        return driver.findElement(accountLocatorText).getText();
    }

    public SearchResultPage search(String keyword) {
        sendKeys(searchBoxLocator, keyword + ENTER);
        return new SearchResultPage(driver);
    }
}
