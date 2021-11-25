import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.openqa.selenium.Keys.ENTER;
import static org.testng.Assert.*;

public class SmokeTest extends BaseTest {

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

        WebElement searchResultTextElement = driver.findElement(By.cssSelector(".dscrptn  h1"));
        String searchResultText = searchResultTextElement.getText();
        assertEquals(searchResultText, "kitap");
    }

    @Test
    public void searchAKeywordWithButton() {
        String keyword = "kitap";
        Homepage homepage = new Homepage(driver);
        SearchResultPage searchResultPage = homepage.search(keyword + ENTER);

        assertTrue(searchResultPage.isProductCardsDisplayed());

        String resultText = searchResultPage.getResultText();
        assertEquals(resultText, keyword);
    }

    @Test
    public void shouldLogin() {
        /**
         * happy path:
         * 1- anasayfayi ac
         * 2- giris yapa tikla
         * 3- user pass gir
         * 4- giris yap butona tkla
         * assertion
         * ----------
         * anasayfaya yonlendirildim
         * sag ustteki giris yap butonu hesabim'a dondu
         * */
        Homepage homepage = new Homepage(driver);
        LoginPage loginPage = homepage.goToLoginPage();
        homepage = loginPage.login();

        String accountText = homepage.getAccountText();
        assertEquals(accountText, "Hesabım");
    }
}
