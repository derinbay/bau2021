import com.bau.test.pages.Homepage;
import com.bau.test.pages.SearchResultPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SearchTest extends BaseTest {

    @Test
    public void searchAKeywordWithButton() {
        String keyword = "kitap";
        Homepage homepage = new Homepage(getDriver());
        SearchResultPage searchResultPage = homepage.search(keyword);

        assertTrue(searchResultPage.isProductCardsDisplayed());

        String resultText = searchResultPage.getResultText();
        assertEquals(resultText, keyword);
    }
}
