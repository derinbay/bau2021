import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;

public class HomepageTest extends BaseTest {

    @Test
    public void goToTrendyolHomepage() {
        WebElement modalCloseButton = getDriver().findElement(By.cssSelector(".modal-close"));
        Boolean modalVisibility = modalCloseButton.isDisplayed();
        assertFalse(modalVisibility);
    }
}
