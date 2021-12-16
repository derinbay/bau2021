import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public WebDriver getDriver() {
        return driver.get();
    }

    @BeforeMethod
    public void startUp() throws MalformedURLException {
        if (System.getProperties().get("remote") != null && System.getProperties().get("remote").equals("true")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");
            driver.set(new RemoteWebDriver(new URL("http://192.168.31.207:4444"), options));
        } else {
            if (System.getProperties().get("browser") != null && System.getProperties().get("browser").equals("chrome")) {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--disable-notifications");
                WebDriverManager.chromedriver().setup();

                if (System.getProperties().get("headless") != null && System.getProperties().get("headless").equals("true")) {
                    options.addArguments("headless");
                }

                driver.set(new ChromeDriver(options));
            } else if (System.getProperties().get("browser").equals("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                driver.set(new FirefoxDriver());
            } else if (System.getProperties().get("browser").equals("edge")) {
                WebDriverManager.edgedriver().setup();
                driver.set(new EdgeDriver());
            } else if (System.getProperties().get("browser").equals("safari")) {
                WebDriverManager.safaridriver().setup();
                driver.set(new SafariDriver());
            }
        }

        getDriver().get("https://www.trendyol.com");
        WebElement modalCloseButton = getDriver().findElement(By.cssSelector(".modal-close"));
        modalCloseButton.click();
    }

    @AfterMethod
    public void tearDown() {
        getDriver().close();
        getDriver().quit();
    }
}
