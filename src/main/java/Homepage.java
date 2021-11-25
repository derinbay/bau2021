import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class Homepage extends BasePage {

    By searchBoxLocator = By.cssSelector(".search-box");

    public Homepage(WebDriver driver) {
        super(driver);
    }

    public LoginPage goToLoginPage() {
        driver.findElement(By.cssSelector(".account-user")).click();
        return new LoginPage(driver);
    }

    public String getAccountText() {
        return driver.findElement(By.cssSelector(".account-user > .link-text")).getText();
    }

    public SearchResultPage search(String keyword) {
        sendKeys(searchBoxLocator, keyword);
        return new SearchResultPage(driver);
    }
}
