import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.openqa.selenium.Keys.ENTER;
import static org.testng.Assert.*;

public class SmokeTest {

    WebDriver driver;

    @BeforeMethod
    public void startUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");

        String projectPath = System.getProperties().get("user.dir").toString();
        System.setProperty("webdriver.chrome.driver", projectPath + "/src/main/resources/chromedriver");
        driver = new ChromeDriver(options);

        driver.get("https://www.trendyol.com");
        WebElement modalCloseButton = driver.findElement(By.cssSelector(".modal-close"));
        modalCloseButton.click();
    }

    @Test
    public void goToTrendyolHomepage() {
        WebElement modalCloseButton = driver.findElement(By.cssSelector(".modal-close"));
        Boolean modalVisibility = modalCloseButton.isDisplayed();
        assertFalse(modalVisibility);
    }

    @Test
    public void searchAKeyword() {
        WebElement searchBoxTextBox = driver.findElement(By.cssSelector(".search-box"));
        searchBoxTextBox.sendKeys("kitap" + ENTER);

        WebElement productCard = driver.findElement(By.cssSelector(".prdct-cntnr-wrppr"));
        assertTrue(productCard.isDisplayed());

        WebElement searchResultTextElement = driver.findElement(By.cssSelector(".dscrptn > h1"));
        String searchResultText = searchResultTextElement.getText();
        assertEquals(searchResultText, "kitap");
    }

    @Test
    public void searchAKeywordWithButton() throws InterruptedException {
        WebElement searchBoxTextBox = driver.findElement(By.cssSelector(".search-box"));
        searchBoxTextBox.sendKeys("kitap");
        Thread.sleep(4000);
        WebElement searchButton = driver.findElement(By.cssSelector(".search-icon"));
        searchButton.click();

        WebElement productCard = driver.findElement(By.cssSelector(".prdct-cntnr-wrppr"));
        assertTrue(productCard.isDisplayed());

        WebElement searchResultTextElement = driver.findElement(By.cssSelector(".dscrptn > h1"));
        String searchResultText = searchResultTextElement.getText();
        assertEquals(searchResultText, "kitap");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    //wait yapilari:
    //implicitWait
    //explicitWait
}
