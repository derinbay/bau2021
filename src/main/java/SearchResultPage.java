import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultPage extends BasePage {

    By productCardLocator = By.cssSelector(".prdct-cntnr-wrppr");
    By resultTextLocator = By.cssSelector(".dscrptn > h1");

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public boolean isProductCardsDisplayed() {
        WebElement productCard = waitForVisibility(productCardLocator);
        return productCard.isDisplayed();
    }

    public String getResultText() {
        return waitForVisibility(resultTextLocator).getText();
    }
}
