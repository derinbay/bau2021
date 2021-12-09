import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    WebDriver driver;

    @BeforeMethod
    public void startUp() {
        if (System.getProperties().get("browser") != null && System.getProperties().get("browser").equals("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");
            WebDriverManager.chromedriver().setup();

            if (System.getProperties().get("headless") != null && System.getProperties().get("headless").equals("true")) {
                options.addArguments("headless");
            }

            driver = new ChromeDriver(options);
        } else if (System.getProperties().get("browser").equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (System.getProperties().get("browser").equals("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else if (System.getProperties().get("browser").equals("safari")) {
            WebDriverManager.safaridriver().setup();
            driver = new SafariDriver();
        }

        driver.get("https://www.trendyol.com");
        WebElement modalCloseButton = driver.findElement(By.cssSelector(".modal-close"));
        modalCloseButton.click();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
