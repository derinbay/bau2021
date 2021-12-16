import com.bau.test.pages.Homepage;
import com.bau.test.pages.LoginPage;
import com.bau.test.users.User;
import org.testng.annotations.Test;

import static com.bau.test.users.UserPool.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {

    @Test
    public void shouldLogin() {
        Homepage homepage = new Homepage(getDriver());
        LoginPage loginPage = homepage.goToLoginPage();

        User user = getValidUser();
        homepage = loginPage.login(user);

        String accountText = homepage.getAccountText();
        assertEquals(accountText, "Hesabım");
    }

    @Test
    public void shouldNotLoginWithWrongPassword() {
        Homepage homepage = new Homepage(getDriver());
        LoginPage loginPage = homepage.goToLoginPage();

        User user = getUserWithWrongPassword();
        loginPage.loginWithWrongPassword(user);

        boolean elementDisplayed = loginPage.isErrorBoxDisplayed();
        assertTrue(elementDisplayed);

        String errorBoxText = loginPage.getErrorBoxText();
        assertEquals(errorBoxText, "E-posta adresiniz ve/veya şifreniz hatalı.");
    }

    @Test
    public void shouldNotLoginWithEmptyPassword() {
        Homepage homepage = new Homepage(getDriver());
        LoginPage loginPage = homepage.goToLoginPage();

        User user = getUserWithEmptyPassword();
        loginPage.loginWithWrongPassword(user);

        boolean elementDisplayed = loginPage.isErrorBoxDisplayed();
        assertTrue(elementDisplayed);

        String errorBoxText = loginPage.getErrorBoxText();
        assertEquals(errorBoxText, "Lütfen şifrenizi giriniz.");
    }

    @Test
    public void shouldNotLoginWithEmptyEmailAndPassword() {
        Homepage homepage = new Homepage(getDriver());
        LoginPage loginPage = homepage.goToLoginPage();

        User user = getUserWithEmptyEmailAndPassword();
        loginPage.loginWithWrongPassword(user);

        boolean elementDisplayed = loginPage.isErrorBoxDisplayed();
        assertTrue(elementDisplayed);

        String errorBoxText = loginPage.getErrorBoxText();
        assertEquals(errorBoxText, "Lütfen geçerli bir e-posta adresi giriniz.");
    }
}
