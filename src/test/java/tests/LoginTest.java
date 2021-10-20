package tests;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Link;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {
    @TmsLink("TMS-1")
    @Issue("TMS-123")//number of ticket
    @Test(description = "Login Valid login should work")
    @Description("test on validlogin")
    @Link("http://tut.by")//link on the documentation
    public void validLogin() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertEquals(productPage.getHeader(), "PRODUCTS", "Wrong page is opened");
    }

    @Test(description = "Login Locket user shouldn't work", retryAnalyzer = Retry.class)
    public void locketUser() {
        loginPage.open();
        loginPage.login("locked_out_user", "secret_sauce");
        assertEquals(loginPage.getError(), "Epic sadface: Sorry, this user has been locked out.", "Wrong error");
    }

    @Test(description = "Login Problem user should work", retryAnalyzer = Retry.class)
    public void problemUser() {
        loginPage.open();
        loginPage.login("problem_user", "secret_sauce");
        assertEquals(productPage.getHeader(), "PRODUCTS", "Wrong page is opened");
    }

    @Test(description = "Login performance_glitch_use should work", retryAnalyzer = Retry.class)
    public void performanceGlitchUser() {
        loginPage.open();
        loginPage.login("performance_glitch_user","secret_sauce");
        assertEquals(productPage.getHeader(), "PRODUCTS", "Wrong page is opened");
    }

    @Test(description = "Click on clear field if the password is incorrect when logging in", retryAnalyzer = Retry.class)
    public void errorDelete() {
        loginPage.open();
        loginPage.loginDelete("locked_out_user", "secret_sauce");
        assertEquals(loginPage.getErrorUser(), "", "Text about epic sadface is not hidden");
    }

}
