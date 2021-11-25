import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

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

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
