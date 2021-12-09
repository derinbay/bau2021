import com.bau.test.pages.Homepage;
import com.bau.test.pages.LoginPage;
import com.bau.test.pages.SearchResultPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SmokeTest extends BaseTest {

    @Test
    public void goToTrendyolHomepage() {
        WebElement modalCloseButton = driver.findElement(By.cssSelector(".modal-close"));
        Boolean modalVisibility = modalCloseButton.isDisplayed();
        assertFalse(modalVisibility);
    }

    @Test
    public void searchAKeywordWithButton() {
        String keyword = "kitap";
        Homepage homepage = new Homepage(driver);
        SearchResultPage searchResultPage = homepage.search(keyword);

        assertTrue(searchResultPage.isProductCardsDisplayed());

        String resultText = searchResultPage.getResultText();
        assertEquals(resultText, keyword);
    }

    @Test
    public void shouldLogin() {
        Homepage homepage = new Homepage(driver);
        LoginPage loginPage = homepage.goToLoginPage();
        homepage = loginPage.login();

        String accountText = homepage.getAccountText();
        assertEquals(accountText, "Hesabımdsadasd");
    }
}
